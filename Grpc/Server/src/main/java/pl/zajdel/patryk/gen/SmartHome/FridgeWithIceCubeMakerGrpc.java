package pl.zajdel.patryk.gen.SmartHome;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: smarthome.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FridgeWithIceCubeMakerGrpc {

  private FridgeWithIceCubeMakerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartHome.FridgeWithIceCubeMaker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesMakerCapacityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIceCubesMakerCapacity",
      requestType = com.google.protobuf.Empty.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesMakerCapacityMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesMakerCapacityMethod;
    if ((getGetIceCubesMakerCapacityMethod = FridgeWithIceCubeMakerGrpc.getGetIceCubesMakerCapacityMethod) == null) {
      synchronized (FridgeWithIceCubeMakerGrpc.class) {
        if ((getGetIceCubesMakerCapacityMethod = FridgeWithIceCubeMakerGrpc.getGetIceCubesMakerCapacityMethod) == null) {
          FridgeWithIceCubeMakerGrpc.getGetIceCubesMakerCapacityMethod = getGetIceCubesMakerCapacityMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIceCubesMakerCapacity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeWithIceCubeMakerMethodDescriptorSupplier("GetIceCubesMakerCapacity"))
              .build();
        }
      }
    }
    return getGetIceCubesMakerCapacityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker,
      pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIceCubes",
      requestType = pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker,
      pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesMethod() {
    io.grpc.MethodDescriptor<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker, pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesMethod;
    if ((getGetIceCubesMethod = FridgeWithIceCubeMakerGrpc.getGetIceCubesMethod) == null) {
      synchronized (FridgeWithIceCubeMakerGrpc.class) {
        if ((getGetIceCubesMethod = FridgeWithIceCubeMakerGrpc.getGetIceCubesMethod) == null) {
          FridgeWithIceCubeMakerGrpc.getGetIceCubesMethod = getGetIceCubesMethod =
              io.grpc.MethodDescriptor.<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker, pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIceCubes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeWithIceCubeMakerMethodDescriptorSupplier("GetIceCubes"))
              .build();
        }
      }
    }
    return getGetIceCubesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesCountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIceCubesCount",
      requestType = com.google.protobuf.Empty.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesCountMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getGetIceCubesCountMethod;
    if ((getGetIceCubesCountMethod = FridgeWithIceCubeMakerGrpc.getGetIceCubesCountMethod) == null) {
      synchronized (FridgeWithIceCubeMakerGrpc.class) {
        if ((getGetIceCubesCountMethod = FridgeWithIceCubeMakerGrpc.getGetIceCubesCountMethod) == null) {
          FridgeWithIceCubeMakerGrpc.getGetIceCubesCountMethod = getGetIceCubesCountMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIceCubesCount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.IceCubesMaker.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeWithIceCubeMakerMethodDescriptorSupplier("GetIceCubesCount"))
              .build();
        }
      }
    }
    return getGetIceCubesCountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FridgeWithIceCubeMakerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeWithIceCubeMakerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeWithIceCubeMakerStub>() {
        @java.lang.Override
        public FridgeWithIceCubeMakerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeWithIceCubeMakerStub(channel, callOptions);
        }
      };
    return FridgeWithIceCubeMakerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FridgeWithIceCubeMakerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeWithIceCubeMakerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeWithIceCubeMakerBlockingStub>() {
        @java.lang.Override
        public FridgeWithIceCubeMakerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeWithIceCubeMakerBlockingStub(channel, callOptions);
        }
      };
    return FridgeWithIceCubeMakerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FridgeWithIceCubeMakerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeWithIceCubeMakerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeWithIceCubeMakerFutureStub>() {
        @java.lang.Override
        public FridgeWithIceCubeMakerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeWithIceCubeMakerFutureStub(channel, callOptions);
        }
      };
    return FridgeWithIceCubeMakerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getIceCubesMakerCapacity(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIceCubesMakerCapacityMethod(), responseObserver);
    }

    /**
     */
    default void getIceCubes(pl.zajdel.patryk.gen.SmartHome.IceCubesMaker request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIceCubesMethod(), responseObserver);
    }

    /**
     */
    default void getIceCubesCount(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIceCubesCountMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FridgeWithIceCubeMaker.
   */
  public static abstract class FridgeWithIceCubeMakerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FridgeWithIceCubeMakerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FridgeWithIceCubeMaker.
   */
  public static final class FridgeWithIceCubeMakerStub
      extends io.grpc.stub.AbstractAsyncStub<FridgeWithIceCubeMakerStub> {
    private FridgeWithIceCubeMakerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeWithIceCubeMakerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeWithIceCubeMakerStub(channel, callOptions);
    }

    /**
     */
    public void getIceCubesMakerCapacity(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIceCubesMakerCapacityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIceCubes(pl.zajdel.patryk.gen.SmartHome.IceCubesMaker request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIceCubesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIceCubesCount(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIceCubesCountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FridgeWithIceCubeMaker.
   */
  public static final class FridgeWithIceCubeMakerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FridgeWithIceCubeMakerBlockingStub> {
    private FridgeWithIceCubeMakerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeWithIceCubeMakerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeWithIceCubeMakerBlockingStub(channel, callOptions);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.IceCubesMaker getIceCubesMakerCapacity(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIceCubesMakerCapacityMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.IceCubesMaker getIceCubes(pl.zajdel.patryk.gen.SmartHome.IceCubesMaker request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIceCubesMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.IceCubesMaker getIceCubesCount(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIceCubesCountMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FridgeWithIceCubeMaker.
   */
  public static final class FridgeWithIceCubeMakerFutureStub
      extends io.grpc.stub.AbstractFutureStub<FridgeWithIceCubeMakerFutureStub> {
    private FridgeWithIceCubeMakerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeWithIceCubeMakerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeWithIceCubeMakerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getIceCubesMakerCapacity(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIceCubesMakerCapacityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getIceCubes(
        pl.zajdel.patryk.gen.SmartHome.IceCubesMaker request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIceCubesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker> getIceCubesCount(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIceCubesCountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ICE_CUBES_MAKER_CAPACITY = 0;
  private static final int METHODID_GET_ICE_CUBES = 1;
  private static final int METHODID_GET_ICE_CUBES_COUNT = 2;

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
        case METHODID_GET_ICE_CUBES_MAKER_CAPACITY:
          serviceImpl.getIceCubesMakerCapacity((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>) responseObserver);
          break;
        case METHODID_GET_ICE_CUBES:
          serviceImpl.getIceCubes((pl.zajdel.patryk.gen.SmartHome.IceCubesMaker) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>) responseObserver);
          break;
        case METHODID_GET_ICE_CUBES_COUNT:
          serviceImpl.getIceCubesCount((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>) responseObserver);
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
          getGetIceCubesMakerCapacityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>(
                service, METHODID_GET_ICE_CUBES_MAKER_CAPACITY)))
        .addMethod(
          getGetIceCubesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pl.zajdel.patryk.gen.SmartHome.IceCubesMaker,
              pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>(
                service, METHODID_GET_ICE_CUBES)))
        .addMethod(
          getGetIceCubesCountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              pl.zajdel.patryk.gen.SmartHome.IceCubesMaker>(
                service, METHODID_GET_ICE_CUBES_COUNT)))
        .build();
  }

  private static abstract class FridgeWithIceCubeMakerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FridgeWithIceCubeMakerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FridgeWithIceCubeMaker");
    }
  }

  private static final class FridgeWithIceCubeMakerFileDescriptorSupplier
      extends FridgeWithIceCubeMakerBaseDescriptorSupplier {
    FridgeWithIceCubeMakerFileDescriptorSupplier() {}
  }

  private static final class FridgeWithIceCubeMakerMethodDescriptorSupplier
      extends FridgeWithIceCubeMakerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FridgeWithIceCubeMakerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FridgeWithIceCubeMakerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FridgeWithIceCubeMakerFileDescriptorSupplier())
              .addMethod(getGetIceCubesMakerCapacityMethod())
              .addMethod(getGetIceCubesMethod())
              .addMethod(getGetIceCubesCountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
