package chat;

import chat.proto.Chat;
import chat.proto.Chat.ChatMessage;
import chat.proto.Chat.CheckMessageRequest;
import chat.proto.Chat.CheckMessageResponse;
import chat.proto.Chat.PostMessageRequest;
import chat.proto.Chat.PostMessageResponse;

import chat.proto.ChatServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class ChatServer {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private Server server;

    private void startServer() throws IOException {
        int port = 5000;

        this.server = ServerBuilder.forPort(port)
                .addService(new ChatImplementation())
                .build()
                .start();
        logger.info("Chat server started... available on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down ***");
                ChatServer.this.stopServer();
                System.err.println("*** server shut down ***");
            }
        });
    }

    private void stopServer() {
        if (this.server != null)
            this.server.shutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (this.server != null) {
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) {
        final ChatServer server = new ChatServer();
        try {
            server.startServer();
            server.blockUntilShutdown();
        } catch (IOException e) {
            System.out.println("Failed to start the server: " + e.getMessage());
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println("Failed to block the main thread until shutdown: " + e.getMessage());
            System.exit(1);
        }
    }

    static class ChatImplementation extends ChatServiceGrpc.ChatServiceImplBase {
        private static List<ChatMessage> messages = new ArrayList<>();

        @Override
        public void checkForMessages(CheckMessageRequest req, StreamObserver<CheckMessageResponse> responseObserver) {
            // Build a checkMessageResponse from the message payload
            Chat.CheckMessageResponseOrBuilder builder = CheckMessageResponse.newBuilder();
            Iterator<ChatMessage> messageIterator = messages.iterator();

            while (messageIterator.hasNext()) {
                ((CheckMessageResponse.Builder) builder).addMessages(messageIterator.next());
            }
            CheckMessageResponse response = ((CheckMessageResponse.Builder) builder).build();

            logger.info("Received fetchMessages request");

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void postMessage(PostMessageRequest req, StreamObserver<PostMessageResponse> responseObserver) {
            ChatMessage cm = ChatMessage.newBuilder()
                    .setUser(req.getUser())
                    .setMessage(req.getMessage())
                    .setTimestamp(LocalDateTime.now().toString())
                    .setId(UUID.randomUUID().toString())
                    .build();

            messages.add(cm);

            logger.info("Received postMessage request from user " + req.getUser());

            responseObserver.onNext(PostMessageResponse.newBuilder().setSuccess(true).build());
            responseObserver.onCompleted();
        }
    }
}
