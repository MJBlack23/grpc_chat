package chat;

import chat.proto.Chat.CheckMessageRequest;
import chat.proto.Chat.CheckMessageResponse;
import chat.proto.Chat.PostMessageRequest;
import chat.proto.Chat.PostMessageResponse;
import chat.proto.Chat.ChatMessage;
import chat.proto.ChatServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatClient {
    private static Logger logger = Logger.getLogger(ChatClient.class.getName());
    private String user;
    private List<ChatMessage> messages = new ArrayList<>();

    private final ManagedChannel channel;
    private final ChatServiceGrpc.ChatServiceBlockingStub blockingStub;

    public ChatClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    ChatClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = ChatServiceGrpc.newBlockingStub(channel);

        logger.setLevel(Level.OFF);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void postMessage(String message) {
        PostMessageRequest request = PostMessageRequest.newBuilder()
                .setUser(this.user)
                .setMessage(message)
                .build();
        PostMessageResponse response;

        try {
            response = blockingStub.postMessage(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC Failed: {0}.", e.getStatus());
            return;
        }

        if (!response.getSuccess()) {
            logger.log(Level.WARNING, "Post Message failed on server...");
        }
    }

    public List<ChatMessage> fetchMessages() {
        CheckMessageRequest request = CheckMessageRequest.newBuilder().build();
        CheckMessageResponse response;

        try {
            response = blockingStub.checkForMessages(request);
            return response.getMessagesList();
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC Failed: {0}.", e.getStatus());
            return new ArrayList<>();
        }
    }

    public void printMessage(ChatMessage msg) {
        boolean userMatch = msg.getUser().equals(this.user);
        String direction = userMatch ? " <- " : " -> ";
        String timeHelper = userMatch ? "  Sent At: " : "  Rcvd At: ";

        LocalDateTime date = LocalDateTime.parse(msg.getTimestamp());

        System.out.println(direction + msg.getUser() + ": " + msg.getMessage());
        System.out.println(timeHelper + date.format(DateTimeFormatter.ofPattern("dd/MM/YY HH:mm:ss")));
        System.out.println(" ");
    }

    public void appendMessages(List<ChatMessage> messages) {
        for (ChatMessage message : messages) {
            if (!this.messages.contains(message)) {
                this.messages.add(message);
            }
        }
    }

    public void sortMessages() {
        this.messages.sort(new SortByTimestamp());
    }

    public void fetchStoreAndDisplayMessages() {
        List<ChatMessage> fetchedMessages = this.fetchMessages();
        this.appendMessages(fetchedMessages);
        this.sortMessages();

        for (ChatMessage msg: this.messages) {
            printMessage(msg);
        }
    }


    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage java client <username>.");
            System.exit(1);
        }

        ChatClient client = new ChatClient("localhost", 5000);
        client.setUser(args[0]);

        String localMessage;

        try (Scanner reader = new Scanner(System.in)){
            do {
                System.out.print(" > ");
                localMessage = reader.nextLine();

                client.postMessage(localMessage);
                client.fetchStoreAndDisplayMessages();
            } while (!localMessage.toLowerCase().equals("exit"));


        } finally {
            client.shutdown();
        }


    }

    class SortByTimestamp implements Comparator<ChatMessage> {
        public int compare(ChatMessage cm1, ChatMessage cm2) {
            if (LocalDateTime.parse(cm1.getTimestamp()).isBefore(LocalDateTime.parse(cm2.getTimestamp()))) {
                return -1;
            } else if (LocalDateTime.parse(cm1.getTimestamp()).isAfter(LocalDateTime.parse(cm2.getTimestamp()))) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
