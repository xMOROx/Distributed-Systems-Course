package pl.zajdel.patryk.Devices;

import com.google.protobuf.Empty;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.C02LevelSafe;
import pl.zajdel.patryk.gen.SmartHome.CO2Level;
import pl.zajdel.patryk.gen.SmartHome.CO2LevelSensorGrpc;
import pl.zajdel.patryk.utils.OperationHelper;

public class CO2LevelSensorImpl extends SmartDeviceImpl implements CO2LevelSensorGrpc.AsyncService {
    private static final int SAFE_LEVEL_THRESHOLD = 5000;
    private static final int CHANGE_LEVEL_MIN_VALUE = -5;
    private static final int CHANGE_LEVEL_MAX_VALUE = 5;
    private static final double CHANGE_LEVEL_PROBABILITY = 0.8;

    private int co2Level;

    public CO2LevelSensorImpl(int co2Level) {
        this.co2Level = co2Level;
    }


    @Override
    public void getCO2LevelInPPM(Empty request, StreamObserver<CO2Level> responseObserver) {

        notifyIfInStandbyMode(responseObserver);

        int co2LevelDelta = Math.random() <= CHANGE_LEVEL_PROBABILITY ?
                OperationHelper.getRandomIntFromRange(CHANGE_LEVEL_MIN_VALUE, CHANGE_LEVEL_MAX_VALUE) : 0;
        int newCO2Level = co2Level + co2LevelDelta;

        if (newCO2Level > 0) {
            co2Level = newCO2Level;
        }

        CO2Level result = CO2Level.newBuilder().setPpm(co2Level).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void isCO2LevelSafe(Empty request, StreamObserver<C02LevelSafe> responseObserver) {
        boolean isSafe = co2Level <= SAFE_LEVEL_THRESHOLD;
        C02LevelSafe result = C02LevelSafe.newBuilder().setSafe(isSafe).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public ServerServiceDefinition bindService() {
        return CO2LevelSensorGrpc.bindService(this);
    }
}
