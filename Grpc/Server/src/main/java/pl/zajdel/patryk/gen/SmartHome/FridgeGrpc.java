package pl.zajdel.patryk.gen.SmartHome;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: smarthome.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FridgeGrpc {

  private FridgeGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartHome.Fridge";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.ModeMessage,
      pl.zajdel.patryk.gen.SmartHome.ModeMessage> getSetModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetMode",
      requestType = pl.zajdel.patryk.gen.SmartHome.ModeMessage.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.ModeMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.ModeMessage,
      pl.zajdel.patryk.gen.SmartHome.ModeMessage> getSetModeMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.ModeMessage, pl.zajdel.patryk.gen.SmartHome.ModeMessage> getSetModeMethod;
    if ((getSetModeMethod = FridgeGrpc.getSetModeMethod) == null) {
      synchronized (FridgeGrpc.class) {
        if ((getSetModeMethod = FridgeGrpc.getSetModeMethod) == null) {
          FridgeGrpc.getSetModeMethod = getSetModeMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.ModeMessage, pl.zajdel.patryk.gen.SmartHome.ModeMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeMethodDescriptorSupplier("SetMode"))
              .build();
        }
      }
    }
    return getSetModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void,
      pl.zajdel.patryk.gen.SmartHome.ModeMessage> getGetModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMode",
      requestType = pl.zajdel.patryk.gen.SmartHome.Void.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.ModeMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void,
      pl.zajdel.patryk.gen.SmartHome.ModeMessage> getGetModeMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void, pl.zajdel.patryk.gen.SmartHome.ModeMessage> getGetModeMethod;
    if ((getGetModeMethod = FridgeGrpc.getGetModeMethod) == null) {
      synchronized (FridgeGrpc.class) {
        if ((getGetModeMethod = FridgeGrpc.getGetModeMethod) == null) {
          FridgeGrpc.getGetModeMethod = getGetModeMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.Void, pl.zajdel.patryk.gen.SmartHome.ModeMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeMethodDescriptorSupplier("GetMode"))
              .build();
        }
      }
    }
    return getGetModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Temperature,
      pl.zajdel.patryk.gen.SmartHome.Temperature> getSetTargetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetTargetTemperature",
      requestType = pl.zajdel.patryk.gen.SmartHome.Temperature.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.Temperature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Temperature,
      pl.zajdel.patryk.gen.SmartHome.Temperature> getSetTargetTemperatureMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Temperature, pl.zajdel.patryk.gen.SmartHome.Temperature> getSetTargetTemperatureMethod;
    if ((getSetTargetTemperatureMethod = FridgeGrpc.getSetTargetTemperatureMethod) == null) {
      synchronized (FridgeGrpc.class) {
        if ((getSetTargetTemperatureMethod = FridgeGrpc.getSetTargetTemperatureMethod) == null) {
          FridgeGrpc.getSetTargetTemperatureMethod = getSetTargetTemperatureMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.Temperature, pl.zajdel.patryk.gen.SmartHome.Temperature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetTargetTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Temperature.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Temperature.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeMethodDescriptorSupplier("SetTargetTemperature"))
              .build();
        }
      }
    }
    return getSetTargetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void,
      pl.zajdel.patryk.gen.SmartHome.Temperature> getGetTargetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTargetTemperature",
      requestType = pl.zajdel.patryk.gen.SmartHome.Void.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.Temperature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void,
      pl.zajdel.patryk.gen.SmartHome.Temperature> getGetTargetTemperatureMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void, pl.zajdel.patryk.gen.SmartHome.Temperature> getGetTargetTemperatureMethod;
    if ((getGetTargetTemperatureMethod = FridgeGrpc.getGetTargetTemperatureMethod) == null) {
      synchronized (FridgeGrpc.class) {
        if ((getGetTargetTemperatureMethod = FridgeGrpc.getGetTargetTemperatureMethod) == null) {
          FridgeGrpc.getGetTargetTemperatureMethod = getGetTargetTemperatureMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.Void, pl.zajdel.patryk.gen.SmartHome.Temperature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTargetTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Temperature.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeMethodDescriptorSupplier("GetTargetTemperature"))
              .build();
        }
      }
    }
    return getGetTargetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void,
      pl.zajdel.patryk.gen.SmartHome.Temperature> getGetCurrentTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentTemperature",
      requestType = pl.zajdel.patryk.gen.SmartHome.Void.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.Temperature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void,
      pl.zajdel.patryk.gen.SmartHome.Temperature> getGetCurrentTemperatureMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.Void, pl.zajdel.patryk.gen.SmartHome.Temperature> getGetCurrentTemperatureMethod;
    if ((getGetCurrentTemperatureMethod = FridgeGrpc.getGetCurrentTemperatureMethod) == null) {
      synchronized (FridgeGrpc.class) {
        if ((getGetCurrentTemperatureMethod = FridgeGrpc.getGetCurrentTemperatureMethod) == null) {
          FridgeGrpc.getGetCurrentTemperatureMethod = getGetCurrentTemperatureMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.Void, pl.zajdel.patryk.gen.SmartHome.Temperature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCurrentTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Temperature.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeMethodDescriptorSupplier("GetCurrentTemperature"))
              .build();
        }
      }
    }
    return getGetCurrentTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FridgeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeStub>() {
        @java.lang.Override
        public FridgeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeStub(channel, callOptions);
        }
      };
    return FridgeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FridgeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeBlockingStub>() {
        @java.lang.Override
        public FridgeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeBlockingStub(channel, callOptions);
        }
      };
    return FridgeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FridgeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeFutureStub>() {
        @java.lang.Override
        public FridgeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeFutureStub(channel, callOptions);
        }
      };
    return FridgeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void setMode(pl.zajdel.patryk.gen.SmartHome.ModeMessage request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ModeMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetModeMethod(), responseObserver);
    }

    /**
     */
    default void getMode(pl.zajdel.patryk.gen.SmartHome.Void request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ModeMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetModeMethod(), responseObserver);
    }

    /**
     */
    default void setTargetTemperature(pl.zajdel.patryk.gen.SmartHome.Temperature request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetTargetTemperatureMethod(), responseObserver);
    }

    /**
     */
    default void getTargetTemperature(pl.zajdel.patryk.gen.SmartHome.Void request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTargetTemperatureMethod(), responseObserver);
    }

    /**
     */
    default void getCurrentTemperature(pl.zajdel.patryk.gen.SmartHome.Void request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentTemperatureMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Fridge.
   */
  public static abstract class FridgeImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FridgeGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Fridge.
   */
  public static final class FridgeStub
      extends io.grpc.stub.AbstractAsyncStub<FridgeStub> {
    private FridgeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeStub(channel, callOptions);
    }

    /**
     */
    public void setMode(pl.zajdel.patryk.gen.SmartHome.ModeMessage request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ModeMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMode(pl.zajdel.patryk.gen.SmartHome.Void request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ModeMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setTargetTemperature(pl.zajdel.patryk.gen.SmartHome.Temperature request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetTargetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTargetTemperature(pl.zajdel.patryk.gen.SmartHome.Void request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTargetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCurrentTemperature(pl.zajdel.patryk.gen.SmartHome.Void request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Fridge.
   */
  public static final class FridgeBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FridgeBlockingStub> {
    private FridgeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeBlockingStub(channel, callOptions);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.ModeMessage setMode(pl.zajdel.patryk.gen.SmartHome.ModeMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.ModeMessage getMode(pl.zajdel.patryk.gen.SmartHome.Void request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.Temperature setTargetTemperature(pl.zajdel.patryk.gen.SmartHome.Temperature request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetTargetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.Temperature getTargetTemperature(pl.zajdel.patryk.gen.SmartHome.Void request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTargetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.Temperature getCurrentTemperature(pl.zajdel.patryk.gen.SmartHome.Void request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Fridge.
   */
  public static final class FridgeFutureStub
      extends io.grpc.stub.AbstractFutureStub<FridgeFutureStub> {
    private FridgeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.ModeMessage> setMode(
        pl.zajdel.patryk.gen.SmartHome.ModeMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetModeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.ModeMessage> getMode(
        pl.zajdel.patryk.gen.SmartHome.Void request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.Temperature> setTargetTemperature(
        pl.zajdel.patryk.gen.SmartHome.Temperature request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetTargetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.Temperature> getTargetTemperature(
        pl.zajdel.patryk.gen.SmartHome.Void request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTargetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.Temperature> getCurrentTemperature(
        pl.zajdel.patryk.gen.SmartHome.Void request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_MODE = 0;
  private static final int METHODID_GET_MODE = 1;
  private static final int METHODID_SET_TARGET_TEMPERATURE = 2;
  private static final int METHODID_GET_TARGET_TEMPERATURE = 3;
  private static final int METHODID_GET_CURRENT_TEMPERATURE = 4;

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
        case METHODID_SET_MODE:
          serviceImpl.setMode((pl.zajdel.patryk.gen.SmartHome.ModeMessage) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ModeMessage>) responseObserver);
          break;
        case METHODID_GET_MODE:
          serviceImpl.getMode((pl.zajdel.patryk.gen.SmartHome.Void) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.ModeMessage>) responseObserver);
          break;
        case METHODID_SET_TARGET_TEMPERATURE:
          serviceImpl.setTargetTemperature((pl.zajdel.patryk.gen.SmartHome.Temperature) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature>) responseObserver);
          break;
        case METHODID_GET_TARGET_TEMPERATURE:
          serviceImpl.getTargetTemperature((pl.zajdel.patryk.gen.SmartHome.Void) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TEMPERATURE:
          serviceImpl.getCurrentTemperature((pl.zajdel.patryk.gen.SmartHome.Void) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.Temperature>) responseObserver);
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
          getSetModeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.ModeMessage,
              pl.zajdel.patryk.gen.SmartHome.ModeMessage>(
                service, METHODID_SET_MODE)))
        .addMethod(
          getGetModeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.Void,
              pl.zajdel.patryk.gen.SmartHome.ModeMessage>(
                service, METHODID_GET_MODE)))
        .addMethod(
          getSetTargetTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.Temperature,
              pl.zajdel.patryk.gen.SmartHome.Temperature>(
                service, METHODID_SET_TARGET_TEMPERATURE)))
        .addMethod(
          getGetTargetTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.Void,
              pl.zajdel.patryk.gen.SmartHome.Temperature>(
                service, METHODID_GET_TARGET_TEMPERATURE)))
        .addMethod(
          getGetCurrentTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.Void,
              pl.zajdel.patryk.gen.SmartHome.Temperature>(
                service, METHODID_GET_CURRENT_TEMPERATURE)))
        .build();
  }

  private static abstract class FridgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FridgeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Fridge");
    }
  }

  private static final class FridgeFileDescriptorSupplier
      extends FridgeBaseDescriptorSupplier {
    FridgeFileDescriptorSupplier() {}
  }

  private static final class FridgeMethodDescriptorSupplier
      extends FridgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FridgeMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FridgeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FridgeFileDescriptorSupplier())
              .addMethod(getSetModeMethod())
              .addMethod(getGetModeMethod())
              .addMethod(getSetTargetTemperatureMethod())
              .addMethod(getGetTargetTemperatureMethod())
              .addMethod(getGetCurrentTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
