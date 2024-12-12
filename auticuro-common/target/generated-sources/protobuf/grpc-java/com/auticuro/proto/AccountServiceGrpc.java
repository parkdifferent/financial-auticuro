package com.auticuro.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Account service for managing accounts
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: wallet.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountServiceGrpc {

  private AccountServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.auticuro.proto.AccountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.auticuro.proto.CreateAccountRequest,
      com.auticuro.proto.CreateAccountResponse> getCreateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccount",
      requestType = com.auticuro.proto.CreateAccountRequest.class,
      responseType = com.auticuro.proto.CreateAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.auticuro.proto.CreateAccountRequest,
      com.auticuro.proto.CreateAccountResponse> getCreateAccountMethod() {
    io.grpc.MethodDescriptor<com.auticuro.proto.CreateAccountRequest, com.auticuro.proto.CreateAccountResponse> getCreateAccountMethod;
    if ((getCreateAccountMethod = AccountServiceGrpc.getCreateAccountMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getCreateAccountMethod = AccountServiceGrpc.getCreateAccountMethod) == null) {
          AccountServiceGrpc.getCreateAccountMethod = getCreateAccountMethod =
              io.grpc.MethodDescriptor.<com.auticuro.proto.CreateAccountRequest, com.auticuro.proto.CreateAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.CreateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.CreateAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("CreateAccount"))
              .build();
        }
      }
    }
    return getCreateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.auticuro.proto.GetAccountRequest,
      com.auticuro.proto.GetAccountResponse> getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.auticuro.proto.GetAccountRequest.class,
      responseType = com.auticuro.proto.GetAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.auticuro.proto.GetAccountRequest,
      com.auticuro.proto.GetAccountResponse> getGetAccountMethod() {
    io.grpc.MethodDescriptor<com.auticuro.proto.GetAccountRequest, com.auticuro.proto.GetAccountResponse> getGetAccountMethod;
    if ((getGetAccountMethod = AccountServiceGrpc.getGetAccountMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getGetAccountMethod = AccountServiceGrpc.getGetAccountMethod) == null) {
          AccountServiceGrpc.getGetAccountMethod = getGetAccountMethod =
              io.grpc.MethodDescriptor.<com.auticuro.proto.GetAccountRequest, com.auticuro.proto.GetAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.GetAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("GetAccount"))
              .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.auticuro.proto.LockAccountRequest,
      com.auticuro.proto.LockAccountResponse> getLockAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LockAccount",
      requestType = com.auticuro.proto.LockAccountRequest.class,
      responseType = com.auticuro.proto.LockAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.auticuro.proto.LockAccountRequest,
      com.auticuro.proto.LockAccountResponse> getLockAccountMethod() {
    io.grpc.MethodDescriptor<com.auticuro.proto.LockAccountRequest, com.auticuro.proto.LockAccountResponse> getLockAccountMethod;
    if ((getLockAccountMethod = AccountServiceGrpc.getLockAccountMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getLockAccountMethod = AccountServiceGrpc.getLockAccountMethod) == null) {
          AccountServiceGrpc.getLockAccountMethod = getLockAccountMethod =
              io.grpc.MethodDescriptor.<com.auticuro.proto.LockAccountRequest, com.auticuro.proto.LockAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LockAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.LockAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.LockAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("LockAccount"))
              .build();
        }
      }
    }
    return getLockAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.auticuro.proto.UnlockAccountRequest,
      com.auticuro.proto.UnlockAccountResponse> getUnlockAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnlockAccount",
      requestType = com.auticuro.proto.UnlockAccountRequest.class,
      responseType = com.auticuro.proto.UnlockAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.auticuro.proto.UnlockAccountRequest,
      com.auticuro.proto.UnlockAccountResponse> getUnlockAccountMethod() {
    io.grpc.MethodDescriptor<com.auticuro.proto.UnlockAccountRequest, com.auticuro.proto.UnlockAccountResponse> getUnlockAccountMethod;
    if ((getUnlockAccountMethod = AccountServiceGrpc.getUnlockAccountMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getUnlockAccountMethod = AccountServiceGrpc.getUnlockAccountMethod) == null) {
          AccountServiceGrpc.getUnlockAccountMethod = getUnlockAccountMethod =
              io.grpc.MethodDescriptor.<com.auticuro.proto.UnlockAccountRequest, com.auticuro.proto.UnlockAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnlockAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.UnlockAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.UnlockAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("UnlockAccount"))
              .build();
        }
      }
    }
    return getUnlockAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.auticuro.proto.UpdateAccountLimitsRequest,
      com.auticuro.proto.UpdateAccountLimitsResponse> getUpdateAccountLimitsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccountLimits",
      requestType = com.auticuro.proto.UpdateAccountLimitsRequest.class,
      responseType = com.auticuro.proto.UpdateAccountLimitsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.auticuro.proto.UpdateAccountLimitsRequest,
      com.auticuro.proto.UpdateAccountLimitsResponse> getUpdateAccountLimitsMethod() {
    io.grpc.MethodDescriptor<com.auticuro.proto.UpdateAccountLimitsRequest, com.auticuro.proto.UpdateAccountLimitsResponse> getUpdateAccountLimitsMethod;
    if ((getUpdateAccountLimitsMethod = AccountServiceGrpc.getUpdateAccountLimitsMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getUpdateAccountLimitsMethod = AccountServiceGrpc.getUpdateAccountLimitsMethod) == null) {
          AccountServiceGrpc.getUpdateAccountLimitsMethod = getUpdateAccountLimitsMethod =
              io.grpc.MethodDescriptor.<com.auticuro.proto.UpdateAccountLimitsRequest, com.auticuro.proto.UpdateAccountLimitsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccountLimits"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.UpdateAccountLimitsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.auticuro.proto.UpdateAccountLimitsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("UpdateAccountLimits"))
              .build();
        }
      }
    }
    return getUpdateAccountLimitsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountServiceStub>() {
        @java.lang.Override
        public AccountServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountServiceStub(channel, callOptions);
        }
      };
    return AccountServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountServiceBlockingStub>() {
        @java.lang.Override
        public AccountServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountServiceBlockingStub(channel, callOptions);
        }
      };
    return AccountServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountServiceFutureStub>() {
        @java.lang.Override
        public AccountServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountServiceFutureStub(channel, callOptions);
        }
      };
    return AccountServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Account service for managing accounts
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createAccount(com.auticuro.proto.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountMethod(), responseObserver);
    }

    /**
     */
    default void getAccount(com.auticuro.proto.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.GetAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     */
    default void lockAccount(com.auticuro.proto.LockAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.LockAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLockAccountMethod(), responseObserver);
    }

    /**
     */
    default void unlockAccount(com.auticuro.proto.UnlockAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.UnlockAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnlockAccountMethod(), responseObserver);
    }

    /**
     */
    default void updateAccountLimits(com.auticuro.proto.UpdateAccountLimitsRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.UpdateAccountLimitsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAccountLimitsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountService.
   * <pre>
   * Account service for managing accounts
   * </pre>
   */
  public static abstract class AccountServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AccountServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountService.
   * <pre>
   * Account service for managing accounts
   * </pre>
   */
  public static final class AccountServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountServiceStub> {
    private AccountServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAccount(com.auticuro.proto.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccount(com.auticuro.proto.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.GetAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lockAccount(com.auticuro.proto.LockAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.LockAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLockAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unlockAccount(com.auticuro.proto.UnlockAccountRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.UnlockAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnlockAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAccountLimits(com.auticuro.proto.UpdateAccountLimitsRequest request,
        io.grpc.stub.StreamObserver<com.auticuro.proto.UpdateAccountLimitsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountLimitsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountService.
   * <pre>
   * Account service for managing accounts
   * </pre>
   */
  public static final class AccountServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountServiceBlockingStub> {
    private AccountServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.auticuro.proto.CreateAccountResponse createAccount(com.auticuro.proto.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.auticuro.proto.GetAccountResponse getAccount(com.auticuro.proto.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.auticuro.proto.LockAccountResponse lockAccount(com.auticuro.proto.LockAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLockAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.auticuro.proto.UnlockAccountResponse unlockAccount(com.auticuro.proto.UnlockAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnlockAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.auticuro.proto.UpdateAccountLimitsResponse updateAccountLimits(com.auticuro.proto.UpdateAccountLimitsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountLimitsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountService.
   * <pre>
   * Account service for managing accounts
   * </pre>
   */
  public static final class AccountServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountServiceFutureStub> {
    private AccountServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.auticuro.proto.CreateAccountResponse> createAccount(
        com.auticuro.proto.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.auticuro.proto.GetAccountResponse> getAccount(
        com.auticuro.proto.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.auticuro.proto.LockAccountResponse> lockAccount(
        com.auticuro.proto.LockAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLockAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.auticuro.proto.UnlockAccountResponse> unlockAccount(
        com.auticuro.proto.UnlockAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnlockAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.auticuro.proto.UpdateAccountLimitsResponse> updateAccountLimits(
        com.auticuro.proto.UpdateAccountLimitsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountLimitsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ACCOUNT = 0;
  private static final int METHODID_GET_ACCOUNT = 1;
  private static final int METHODID_LOCK_ACCOUNT = 2;
  private static final int METHODID_UNLOCK_ACCOUNT = 3;
  private static final int METHODID_UPDATE_ACCOUNT_LIMITS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ACCOUNT:
          serviceImpl.createAccount((com.auticuro.proto.CreateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.auticuro.proto.CreateAccountResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount((com.auticuro.proto.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.auticuro.proto.GetAccountResponse>) responseObserver);
          break;
        case METHODID_LOCK_ACCOUNT:
          serviceImpl.lockAccount((com.auticuro.proto.LockAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.auticuro.proto.LockAccountResponse>) responseObserver);
          break;
        case METHODID_UNLOCK_ACCOUNT:
          serviceImpl.unlockAccount((com.auticuro.proto.UnlockAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.auticuro.proto.UnlockAccountResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT_LIMITS:
          serviceImpl.updateAccountLimits((com.auticuro.proto.UpdateAccountLimitsRequest) request,
              (io.grpc.stub.StreamObserver<com.auticuro.proto.UpdateAccountLimitsResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.auticuro.proto.CreateAccountRequest,
              com.auticuro.proto.CreateAccountResponse>(
                service, METHODID_CREATE_ACCOUNT)))
        .addMethod(
          getGetAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.auticuro.proto.GetAccountRequest,
              com.auticuro.proto.GetAccountResponse>(
                service, METHODID_GET_ACCOUNT)))
        .addMethod(
          getLockAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.auticuro.proto.LockAccountRequest,
              com.auticuro.proto.LockAccountResponse>(
                service, METHODID_LOCK_ACCOUNT)))
        .addMethod(
          getUnlockAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.auticuro.proto.UnlockAccountRequest,
              com.auticuro.proto.UnlockAccountResponse>(
                service, METHODID_UNLOCK_ACCOUNT)))
        .addMethod(
          getUpdateAccountLimitsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.auticuro.proto.UpdateAccountLimitsRequest,
              com.auticuro.proto.UpdateAccountLimitsResponse>(
                service, METHODID_UPDATE_ACCOUNT_LIMITS)))
        .build();
  }

  private static abstract class AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.auticuro.proto.WalletProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountService");
    }
  }

  private static final class AccountServiceFileDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier {
    AccountServiceFileDescriptorSupplier() {}
  }

  private static final class AccountServiceMethodDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountServiceFileDescriptorSupplier())
              .addMethod(getCreateAccountMethod())
              .addMethod(getGetAccountMethod())
              .addMethod(getLockAccountMethod())
              .addMethod(getUnlockAccountMethod())
              .addMethod(getUpdateAccountLimitsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
