package pl.zajdel.patryk.Devices;

import io.grpc.BindableService;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.Void;
import pl.zajdel.patryk.gen.SmartHome.*;
import pl.zajdel.patryk.utils.OperationHelper;

public class SmartDeviceImpl implements SmartDeviceGrpc.AsyncService, BindableService {
    protected Mode mode = Mode.ON;

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
        responseObserver.onCompleted();
    }

    @Override
    public void getMode(Void request, StreamObserver<ModeMessage> responseObserver) {
        ModeMessage result = ModeMessage.newBuilder().setMode(mode).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    protected boolean notifyIfInStandbyMode(StreamObserver<?> responseObserver) {
        if (mode == Mode.STANDBY) {
            responseObserver.onError(
                    Status.FAILED_PRECONDITION
                            .withDescription("Device is in standby mode")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.IN_STANDBY_MODE, "Device is in standby mode"))
            );
            return true;
        }
        return false;
    }


    @Override
    public ServerServiceDefinition bindService() {
        return SmartDeviceGrpc.bindService(this);
    }
}
