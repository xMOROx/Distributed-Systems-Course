package pl.zajdel.patryk.Devices;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.Mode;
import pl.zajdel.patryk.gen.SmartHome.ModeMessage;
import pl.zajdel.patryk.gen.SmartHome.SmartDeviceGrpc;
import pl.zajdel.patryk.utils.OperationHelper;

public abstract class SmartDeviceImpl implements SmartDeviceGrpc.AsyncService {
    private Mode mode = Mode.ON;

    @Override
    public void setMode(ModeMessage request, StreamObserver<ModeMessage> responseObserver) {
        if (request.getMode() == mode) {
            responseObserver.onError(
                    Status.ALREADY_EXISTS
                            .withDescription("Device mode not changed")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.MODE_NOT_CHANGED, "Device is already in " + mode + " mode"))
            );
            return;
        }

        mode = request.getMode();
        responseObserver.onNext(ModeMessage.newBuilder().setMode(mode).build());
    }

    @Override
    public void getMode(Empty request, StreamObserver<ModeMessage> responseObserver) {
        ModeMessage result = ModeMessage.newBuilder().setMode(mode).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void notifyIfInStandbyMode(Empty request, StreamObserver<Empty> responseObserver) {
        if (mode == Mode.STANDBY) {
            responseObserver.onError(
                    Status.FAILED_PRECONDITION
                            .withDescription("Device is in standby mode")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.IN_STANDBY_MODE, "Device is in standby mode"))
            );
        }
    }
}
