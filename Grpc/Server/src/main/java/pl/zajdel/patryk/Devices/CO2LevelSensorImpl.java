package pl.zajdel.patryk.Devices;

import io.grpc.BindableService;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.C02LevelSafe;
import pl.zajdel.patryk.gen.SmartHome.CO2Level;
import pl.zajdel.patryk.gen.SmartHome.CO2LevelSensorGrpc;
import pl.zajdel.patryk.gen.SmartHome.Void;
import pl.zajdel.patryk.utils.OperationHelper;

public class CO2LevelSensorImpl extends SmartDeviceImpl implements CO2LevelSensorGrpc.AsyncService, BindableService {
    private static final int SAFE_LEVEL_THRESHOLD = 5000;
    private static final int CHANGE_LEVEL_MIN_VALUE = -5;
    private static final int CHANGE_LEVEL_MAX_VALUE = 5;
    private static final double CHANGE_LEVEL_PROBABILITY = 0.8;
    private int co2Level;


    public CO2LevelSensorImpl(int co2Level, String socket) {
        super(socket);
        this.co2Level = co2Level;
    }


    @Override
    public void getCO2LevelInPPM(Void request, StreamObserver<CO2Level> responseObserver) {
        if (notifyIfInStandbyMode(responseObserver)) return;


        int co2LevelDelta = Math.random() <= CHANGE_LEVEL_PROBABILITY ?
                OperationHelper.getRandomIntFromRange(CHANGE_LEVEL_MIN_VALUE, CHANGE_LEVEL_MAX_VALUE) : 0;
        int newCO2Level = co2Level + co2LevelDelta;

        if (newCO2Level > 0) {
            co2Level = newCO2Level;
        }

        CO2Level result = CO2Level.newBuilder().setPpm(co2Level).build();
        logger.info("CO2 level: " + co2Level + " ppm" + " for server: " + serverSocket);

        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void isCO2LevelSafe(Void request, StreamObserver<C02LevelSafe> responseObserver) {
        boolean isSafe = co2Level <= SAFE_LEVEL_THRESHOLD;
        C02LevelSafe result = C02LevelSafe.newBuilder().setSafe(isSafe).build();

        logger.info("CO2 level is safe: " + isSafe + " for server: " + serverSocket);

        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }


    @Override
    public ServerServiceDefinition bindService() {
        return CO2LevelSensorGrpc.bindService(this);
    }


}
