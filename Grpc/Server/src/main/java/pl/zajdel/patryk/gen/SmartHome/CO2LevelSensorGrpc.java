package pl.zajdel.patryk.gen.SmartHome;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: smarthome.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CO2LevelSensorGrpc {

  private CO2LevelSensorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartHome.CO2LevelSensor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.CO2Level> getGetCO2LevelInPPMMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCO2LevelInPPM",
      requestType = com.google.protobuf.Empty.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.CO2Level.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.CO2Level> getGetCO2LevelInPPMMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.CO2Level> getGetCO2LevelInPPMMethod;
    if ((getGetCO2LevelInPPMMethod = CO2LevelSensorGrpc.getGetCO2LevelInPPMMethod) == null) {
      synchronized (CO2LevelSensorGrpc.class) {
        if ((getGetCO2LevelInPPMMethod = CO2LevelSensorGrpc.getGetCO2LevelInPPMMethod) == null) {
          CO2LevelSensorGrpc.getGetCO2LevelInPPMMethod = getGetCO2LevelInPPMMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.CO2Level>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCO2LevelInPPM"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.CO2Level.getDefaultInstance()))
              .setSchemaDescriptor(new CO2LevelSensorMethodDescriptorSupplier("GetCO2LevelInPPM"))
              .build();
        }
      }
    }
    return getGetCO2LevelInPPMMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.C02LevelSafe> getIsCO2LevelSafeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsCO2LevelSafe",
      requestType = com.google.protobuf.Empty.class,
      responseType = pl.zajdel.patryk.gen.SmartHome.C02LevelSafe.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      pl.zajdel.patryk.gen.SmartHome.C02LevelSafe> getIsCO2LevelSafeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.C02LevelSafe> getIsCO2LevelSafeMethod;
    if ((getIsCO2LevelSafeMethod = CO2LevelSensorGrpc.getIsCO2LevelSafeMethod) == null) {
      synchronized (CO2LevelSensorGrpc.class) {
        if ((getIsCO2LevelSafeMethod = CO2LevelSensorGrpc.getIsCO2LevelSafeMethod) == null) {
          CO2LevelSensorGrpc.getIsCO2LevelSafeMethod = getIsCO2LevelSafeMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, pl.zajdel.patryk.gen.SmartHome.C02LevelSafe>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IsCO2LevelSafe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.zajdel.patryk.gen.SmartHome.C02LevelSafe.getDefaultInstance()))
              .setSchemaDescriptor(new CO2LevelSensorMethodDescriptorSupplier("IsCO2LevelSafe"))
              .build();
        }
      }
    }
    return getIsCO2LevelSafeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CO2LevelSensorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CO2LevelSensorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CO2LevelSensorStub>() {
        @java.lang.Override
        public CO2LevelSensorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CO2LevelSensorStub(channel, callOptions);
        }
      };
    return CO2LevelSensorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CO2LevelSensorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CO2LevelSensorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CO2LevelSensorBlockingStub>() {
        @java.lang.Override
        public CO2LevelSensorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CO2LevelSensorBlockingStub(channel, callOptions);
        }
      };
    return CO2LevelSensorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CO2LevelSensorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CO2LevelSensorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CO2LevelSensorFutureStub>() {
        @java.lang.Override
        public CO2LevelSensorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CO2LevelSensorFutureStub(channel, callOptions);
        }
      };
    return CO2LevelSensorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getCO2LevelInPPM(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.CO2Level> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCO2LevelInPPMMethod(), responseObserver);
    }

    /**
     */
    default void isCO2LevelSafe(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.C02LevelSafe> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsCO2LevelSafeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CO2LevelSensor.
   */
  public static abstract class CO2LevelSensorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CO2LevelSensorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CO2LevelSensor.
   */
  public static final class CO2LevelSensorStub
      extends io.grpc.stub.AbstractAsyncStub<CO2LevelSensorStub> {
    private CO2LevelSensorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CO2LevelSensorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CO2LevelSensorStub(channel, callOptions);
    }

    /**
     */
    public void getCO2LevelInPPM(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.CO2Level> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCO2LevelInPPMMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isCO2LevelSafe(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.C02LevelSafe> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsCO2LevelSafeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CO2LevelSensor.
   */
  public static final class CO2LevelSensorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CO2LevelSensorBlockingStub> {
    private CO2LevelSensorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CO2LevelSensorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CO2LevelSensorBlockingStub(channel, callOptions);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.CO2Level getCO2LevelInPPM(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCO2LevelInPPMMethod(), getCallOptions(), request);
    }

    /**
     */
    public pl.zajdel.patryk.gen.SmartHome.C02LevelSafe isCO2LevelSafe(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsCO2LevelSafeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CO2LevelSensor.
   */
  public static final class CO2LevelSensorFutureStub
      extends io.grpc.stub.AbstractFutureStub<CO2LevelSensorFutureStub> {
    private CO2LevelSensorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CO2LevelSensorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CO2LevelSensorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.CO2Level> getCO2LevelInPPM(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCO2LevelInPPMMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pl.zajdel.patryk.gen.SmartHome.C02LevelSafe> isCO2LevelSafe(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsCO2LevelSafeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CO2LEVEL_IN_PPM = 0;
  private static final int METHODID_IS_CO2LEVEL_SAFE = 1;

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
        case METHODID_GET_CO2LEVEL_IN_PPM:
          serviceImpl.getCO2LevelInPPM((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.CO2Level>) responseObserver);
          break;
        case METHODID_IS_CO2LEVEL_SAFE:
          serviceImpl.isCO2LevelSafe((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<pl.zajdel.patryk.gen.SmartHome.C02LevelSafe>) responseObserver);
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
          getGetCO2LevelInPPMMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              pl.zajdel.patryk.gen.SmartHome.CO2Level>(
                service, METHODID_GET_CO2LEVEL_IN_PPM)))
        .addMethod(
          getIsCO2LevelSafeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              pl.zajdel.patryk.gen.SmartHome.C02LevelSafe>(
                service, METHODID_IS_CO2LEVEL_SAFE)))
        .build();
  }

  private static abstract class CO2LevelSensorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CO2LevelSensorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CO2LevelSensor");
    }
  }

  private static final class CO2LevelSensorFileDescriptorSupplier
      extends CO2LevelSensorBaseDescriptorSupplier {
    CO2LevelSensorFileDescriptorSupplier() {}
  }

  private static final class CO2LevelSensorMethodDescriptorSupplier
      extends CO2LevelSensorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CO2LevelSensorMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CO2LevelSensorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CO2LevelSensorFileDescriptorSupplier())
              .addMethod(getGetCO2LevelInPPMMethod())
              .addMethod(getIsCO2LevelSafeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
