package pl.zajdel.patryk.gen.SmartHome;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Interface definitions as Services
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: smarthome.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SmartDeviceGrpc {

  private SmartDeviceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartHome.SmartDevice";

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
    if ((getSetModeMethod = SmartDeviceGrpc.getSetModeMethod) == null) {
      synchronized (SmartDeviceGrpc.class) {
        if ((getSetModeMethod = SmartDeviceGrpc.getSetModeMethod) == null) {
          SmartDeviceGrpc.getSetModeMethod = getSetModeMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.ModeMessage, pl.zajdel.patryk.gen.SmartHome.ModeMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance()))
              .setSchemaDescriptor(new SmartDeviceMethodDescriptorSupplier("SetMode"))
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
    if ((getGetModeMethod = SmartDeviceGrpc.getGetModeMethod) == null) {
      synchronized (SmartDeviceGrpc.class) {
        if ((getGetModeMethod = SmartDeviceGrpc.getGetModeMethod) == null) {
          SmartDeviceGrpc.getGetModeMethod = getGetModeMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.Void, pl.zajdel.patryk.gen.SmartHome.ModeMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance()))
              .setSchemaDescriptor(new SmartDeviceMethodDescriptorSupplier("GetMode"))
              .build();
        }
      }
    }
    return getGetModeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartDeviceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartDeviceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartDeviceStub>() {
        @java.lang.Override
        public SmartDeviceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartDeviceStub(channel, callOptions);
        }
      };
    return SmartDeviceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartDeviceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartDeviceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartDeviceBlockingStub>() {
        @java.lang.Override
        public SmartDeviceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartDeviceBlockingStub(channel, callOptions);
        }
      };
    return SmartDeviceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartDeviceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartDeviceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartDeviceFutureStub>() {
        @java.lang.Override
        public SmartDeviceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartDeviceFutureStub(channel, callOptions);
        }
      };
    return SmartDeviceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Interface definitions as Services
   * </pre>
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
  }

  /**
   * Base class for the server implementation of the service SmartDevice.
   * <pre>
   * Interface definitions as Services
   * </pre>
   */
  public static abstract class SmartDeviceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SmartDeviceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SmartDevice.
   * <pre>
   * Interface definitions as Services
   * </pre>
   */
  public static final class SmartDeviceStub
      extends io.grpc.stub.AbstractAsyncStub<SmartDeviceStub> {
    private SmartDeviceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartDeviceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartDeviceStub(channel, callOptions);
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
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SmartDevice.
   * <pre>
   * Interface definitions as Services
   * </pre>
   */
  public static final class SmartDeviceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SmartDeviceBlockingStub> {
    private SmartDeviceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartDeviceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartDeviceBlockingStub(channel, callOptions);
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
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SmartDevice.
   * <pre>
   * Interface definitions as Services
   * </pre>
   */
  public static final class SmartDeviceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SmartDeviceFutureStub> {
    private SmartDeviceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartDeviceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartDeviceFutureStub(channel, callOptions);
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
  }

  private static final int METHODID_SET_MODE = 0;
  private static final int METHODID_GET_MODE = 1;

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
        .build();
  }

  private static abstract class SmartDeviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartDeviceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartDevice");
    }
  }

  private static final class SmartDeviceFileDescriptorSupplier
      extends SmartDeviceBaseDescriptorSupplier {
    SmartDeviceFileDescriptorSupplier() {}
  }

  private static final class SmartDeviceMethodDescriptorSupplier
      extends SmartDeviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SmartDeviceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SmartDeviceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartDeviceFileDescriptorSupplier())
              .addMethod(getSetModeMethod())
              .addMethod(getGetModeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
