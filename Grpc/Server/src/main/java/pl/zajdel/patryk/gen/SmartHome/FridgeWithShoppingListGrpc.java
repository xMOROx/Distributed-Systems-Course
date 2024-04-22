package pl.zajdel.patryk.gen.SmartHome;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: smarthome.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FridgeWithShoppingListGrpc {

  private FridgeWithShoppingListGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartHome.FridgeWithShoppingList";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord> getGetShoppingListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShoppingList",
      requestType = com.google.protobuf.Empty.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord> getGetShoppingListMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord> getGetShoppingListMethod;
    if ((getGetShoppingListMethod = FridgeWithShoppingListGrpc.getGetShoppingListMethod) == null) {
      synchronized (FridgeWithShoppingListGrpc.class) {
        if ((getGetShoppingListMethod = FridgeWithShoppingListGrpc.getGetShoppingListMethod) == null) {
          FridgeWithShoppingListGrpc.getGetShoppingListMethod = getGetShoppingListMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetShoppingList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeWithShoppingListMethodDescriptorSupplier("GetShoppingList"))
              .build();
        }
      }
    }
    return getGetShoppingListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord,
      pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> getAddShoppingListRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddShoppingListRecord",
      requestType = pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord,
      pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> getAddShoppingListRecordMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord, pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> getAddShoppingListRecordMethod;
    if ((getAddShoppingListRecordMethod = FridgeWithShoppingListGrpc.getAddShoppingListRecordMethod) == null) {
      synchronized (FridgeWithShoppingListGrpc.class) {
        if ((getAddShoppingListRecordMethod = FridgeWithShoppingListGrpc.getAddShoppingListRecordMethod) == null) {
          FridgeWithShoppingListGrpc.getAddShoppingListRecordMethod = getAddShoppingListRecordMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord, pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddShoppingListRecord"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeWithShoppingListMethodDescriptorSupplier("AddShoppingListRecord"))
              .build();
        }
      }
    }
    return getAddShoppingListRecordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping,
      pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> getRemoveShoppingListRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveShoppingListRecord",
      requestType = pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping,
      pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> getRemoveShoppingListRecordMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping, pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> getRemoveShoppingListRecordMethod;
    if ((getRemoveShoppingListRecordMethod = FridgeWithShoppingListGrpc.getRemoveShoppingListRecordMethod) == null) {
      synchronized (FridgeWithShoppingListGrpc.class) {
        if ((getRemoveShoppingListRecordMethod = FridgeWithShoppingListGrpc.getRemoveShoppingListRecordMethod) == null) {
          FridgeWithShoppingListGrpc.getRemoveShoppingListRecordMethod = getRemoveShoppingListRecordMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping, pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveShoppingListRecord"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeWithShoppingListMethodDescriptorSupplier("RemoveShoppingListRecord"))
              .build();
        }
      }
    }
    return getRemoveShoppingListRecordMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FridgeWithShoppingListStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeWithShoppingListStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeWithShoppingListStub>() {
        @java.lang.Override
        public FridgeWithShoppingListStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeWithShoppingListStub(channel, callOptions);
        }
      };
    return FridgeWithShoppingListStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FridgeWithShoppingListBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeWithShoppingListBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeWithShoppingListBlockingStub>() {
        @java.lang.Override
        public FridgeWithShoppingListBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeWithShoppingListBlockingStub(channel, callOptions);
        }
      };
    return FridgeWithShoppingListBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FridgeWithShoppingListFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeWithShoppingListFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeWithShoppingListFutureStub>() {
        @java.lang.Override
        public FridgeWithShoppingListFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeWithShoppingListFutureStub(channel, callOptions);
        }
      };
    return FridgeWithShoppingListFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getShoppingList(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShoppingListMethod(), responseObserver);
    }

    /**
     */
    default void addShoppingListRecord(pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddShoppingListRecordMethod(), responseObserver);
    }

    /**
     */
    default void removeShoppingListRecord(pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveShoppingListRecordMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FridgeWithShoppingList.
   */
  public static abstract class FridgeWithShoppingListImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FridgeWithShoppingListGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FridgeWithShoppingList.
   */
  public static final class FridgeWithShoppingListStub
      extends io.grpc.stub.AbstractAsyncStub<FridgeWithShoppingListStub> {
    private FridgeWithShoppingListStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeWithShoppingListStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeWithShoppingListStub(channel, callOptions);
    }

    /**
     */
    public void getShoppingList(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShoppingListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addShoppingListRecord(pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddShoppingListRecordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeShoppingListRecord(pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveShoppingListRecordMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FridgeWithShoppingList.
   */
  public static final class FridgeWithShoppingListBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FridgeWithShoppingListBlockingStub> {
    private FridgeWithShoppingListBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeWithShoppingListBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeWithShoppingListBlockingStub(channel, callOptions);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord getShoppingList(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShoppingListMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord addShoppingListRecord(pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddShoppingListRecordMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord removeShoppingListRecord(pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveShoppingListRecordMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FridgeWithShoppingList.
   */
  public static final class FridgeWithShoppingListFutureStub
      extends io.grpc.stub.AbstractFutureStub<FridgeWithShoppingListFutureStub> {
    private FridgeWithShoppingListFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeWithShoppingListFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeWithShoppingListFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord> getShoppingList(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShoppingListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> addShoppingListRecord(
        pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddShoppingListRecordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord> removeShoppingListRecord(
        pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveShoppingListRecordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SHOPPING_LIST = 0;
  private static final int METHODID_ADD_SHOPPING_LIST_RECORD = 1;
  private static final int METHODID_REMOVE_SHOPPING_LIST_RECORD = 2;

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
        case METHODID_GET_SHOPPING_LIST:
          serviceImpl.getShoppingList((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord>) responseObserver);
          break;
        case METHODID_ADD_SHOPPING_LIST_RECORD:
          serviceImpl.addShoppingListRecord((pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord>) responseObserver);
          break;
        case METHODID_REMOVE_SHOPPING_LIST_RECORD:
          serviceImpl.removeShoppingListRecord((pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord>) responseObserver);
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
          getGetShoppingListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              pl.zajdel.patryk.gen.SmartHome.OrderedShoppingListRecord>(
                service, METHODID_GET_SHOPPING_LIST)))
        .addMethod(
          getAddShoppingListRecordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord,
              pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord>(
                service, METHODID_ADD_SHOPPING_LIST_RECORD)))
        .addMethod(
          getRemoveShoppingListRecordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping,
              pl.zajdel.patryk.gen.SmartHome.ShoppingListRecord>(
                service, METHODID_REMOVE_SHOPPING_LIST_RECORD)))
        .build();
  }

  private static abstract class FridgeWithShoppingListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FridgeWithShoppingListBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FridgeWithShoppingList");
    }
  }

  private static final class FridgeWithShoppingListFileDescriptorSupplier
      extends FridgeWithShoppingListBaseDescriptorSupplier {
    FridgeWithShoppingListFileDescriptorSupplier() {}
  }

  private static final class FridgeWithShoppingListMethodDescriptorSupplier
      extends FridgeWithShoppingListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FridgeWithShoppingListMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FridgeWithShoppingListGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FridgeWithShoppingListFileDescriptorSupplier())
              .addMethod(getGetShoppingListMethod())
              .addMethod(getAddShoppingListRecordMethod())
              .addMethod(getRemoveShoppingListRecordMethod())
              .build();
        }
      }
    }
    return result;
  }
}
