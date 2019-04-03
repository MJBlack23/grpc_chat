package chat.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: chat.proto")
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "chat.ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<chat.proto.Chat.CheckMessageRequest,
      chat.proto.Chat.CheckMessageResponse> getCheckForMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkForMessages",
      requestType = chat.proto.Chat.CheckMessageRequest.class,
      responseType = chat.proto.Chat.CheckMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chat.proto.Chat.CheckMessageRequest,
      chat.proto.Chat.CheckMessageResponse> getCheckForMessagesMethod() {
    io.grpc.MethodDescriptor<chat.proto.Chat.CheckMessageRequest, chat.proto.Chat.CheckMessageResponse> getCheckForMessagesMethod;
    if ((getCheckForMessagesMethod = ChatServiceGrpc.getCheckForMessagesMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getCheckForMessagesMethod = ChatServiceGrpc.getCheckForMessagesMethod) == null) {
          ChatServiceGrpc.getCheckForMessagesMethod = getCheckForMessagesMethod = 
              io.grpc.MethodDescriptor.<chat.proto.Chat.CheckMessageRequest, chat.proto.Chat.CheckMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chat.ChatService", "checkForMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.proto.Chat.CheckMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.proto.Chat.CheckMessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("checkForMessages"))
                  .build();
          }
        }
     }
     return getCheckForMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<chat.proto.Chat.PostMessageRequest,
      chat.proto.Chat.PostMessageResponse> getPostMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "postMessage",
      requestType = chat.proto.Chat.PostMessageRequest.class,
      responseType = chat.proto.Chat.PostMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chat.proto.Chat.PostMessageRequest,
      chat.proto.Chat.PostMessageResponse> getPostMessageMethod() {
    io.grpc.MethodDescriptor<chat.proto.Chat.PostMessageRequest, chat.proto.Chat.PostMessageResponse> getPostMessageMethod;
    if ((getPostMessageMethod = ChatServiceGrpc.getPostMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getPostMessageMethod = ChatServiceGrpc.getPostMessageMethod) == null) {
          ChatServiceGrpc.getPostMessageMethod = getPostMessageMethod = 
              io.grpc.MethodDescriptor.<chat.proto.Chat.PostMessageRequest, chat.proto.Chat.PostMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chat.ChatService", "postMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.proto.Chat.PostMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chat.proto.Chat.PostMessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("postMessage"))
                  .build();
          }
        }
     }
     return getPostMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    return new ChatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkForMessages(chat.proto.Chat.CheckMessageRequest request,
        io.grpc.stub.StreamObserver<chat.proto.Chat.CheckMessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckForMessagesMethod(), responseObserver);
    }

    /**
     */
    public void postMessage(chat.proto.Chat.PostMessageRequest request,
        io.grpc.stub.StreamObserver<chat.proto.Chat.PostMessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPostMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckForMessagesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chat.proto.Chat.CheckMessageRequest,
                chat.proto.Chat.CheckMessageResponse>(
                  this, METHODID_CHECK_FOR_MESSAGES)))
          .addMethod(
            getPostMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chat.proto.Chat.PostMessageRequest,
                chat.proto.Chat.PostMessageResponse>(
                  this, METHODID_POST_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatServiceStub extends io.grpc.stub.AbstractStub<ChatServiceStub> {
    private ChatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkForMessages(chat.proto.Chat.CheckMessageRequest request,
        io.grpc.stub.StreamObserver<chat.proto.Chat.CheckMessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckForMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postMessage(chat.proto.Chat.PostMessageRequest request,
        io.grpc.stub.StreamObserver<chat.proto.Chat.PostMessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public chat.proto.Chat.CheckMessageResponse checkForMessages(chat.proto.Chat.CheckMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckForMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public chat.proto.Chat.PostMessageResponse postMessage(chat.proto.Chat.PostMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getPostMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chat.proto.Chat.CheckMessageResponse> checkForMessages(
        chat.proto.Chat.CheckMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckForMessagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chat.proto.Chat.PostMessageResponse> postMessage(
        chat.proto.Chat.PostMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPostMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_FOR_MESSAGES = 0;
  private static final int METHODID_POST_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_FOR_MESSAGES:
          serviceImpl.checkForMessages((chat.proto.Chat.CheckMessageRequest) request,
              (io.grpc.stub.StreamObserver<chat.proto.Chat.CheckMessageResponse>) responseObserver);
          break;
        case METHODID_POST_MESSAGE:
          serviceImpl.postMessage((chat.proto.Chat.PostMessageRequest) request,
              (io.grpc.stub.StreamObserver<chat.proto.Chat.PostMessageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chat.proto.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getCheckForMessagesMethod())
              .addMethod(getPostMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
