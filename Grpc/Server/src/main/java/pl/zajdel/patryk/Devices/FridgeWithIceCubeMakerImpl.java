package pl.zajdel.patryk.Devices;

import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.Void;
import pl.zajdel.patryk.gen.SmartHome.*;
import pl.zajdel.patryk.utils.OperationHelper;

public class FridgeWithIceCubeMakerImpl extends FridgeImpl implements FridgeWithIceCubeMakerGrpc.AsyncService {
    private static final int ICE_CUBES_MAKER_CAPACITY = 100;
    private int iceCubesCount;

    public FridgeWithIceCubeMakerImpl(float targetTemperature, float currentTemperature, int iceCubesCount) {
        super(targetTemperature, currentTemperature);
        this.iceCubesCount = checkIfValidIceCubesCount(iceCubesCount) ? iceCubesCount : 0;
    }

    @Override
    public void setMode(ModeMessage request,
                        StreamObserver<ModeMessage> responseObserver) {
        super.setMode(request, responseObserver);
    }

    @Override
    public void getIceCubesMakerCapacity(Void request, StreamObserver<IceCubesMaker> responseObserver) {
        responseObserver.onNext(IceCubesMaker.newBuilder().setIceCubes(ICE_CUBES_MAKER_CAPACITY).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getIceCubes(IceCubesMaker request, StreamObserver<IceCubesMaker> responseObserver) {
        if(notifyIfInStandbyMode(responseObserver)) return;

        int iceCubeRequestedAmount = request.getIceCubes();

        if (!OperationHelper.checkIfValueInRange(iceCubeRequestedAmount, 1, iceCubesCount)) {
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Requested ice cubes count out of range")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.NOT_ENOUGH_ICE_CUBES, "Requested ice cubes count out of range"))
            );
            return;
        }

        iceCubesCount -= iceCubeRequestedAmount;
        responseObserver.onNext(IceCubesMaker.newBuilder().setIceCubes(iceCubeRequestedAmount).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getIceCubesCount(Void request, StreamObserver<IceCubesMaker> responseObserver) {
        if(notifyIfInStandbyMode(responseObserver)) return;

        responseObserver.onNext(IceCubesMaker.newBuilder().setIceCubes(iceCubesCount).build());
        responseObserver.onCompleted();
    }

    private boolean checkIfValidIceCubesCount(int iceCubesCount) {
        return OperationHelper.checkIfValueInRange(iceCubesCount, 0, ICE_CUBES_MAKER_CAPACITY);
    }

    @Override
    public ServerServiceDefinition bindService() {
        return FridgeWithIceCubeMakerGrpc.bindService(this);
    }
}
