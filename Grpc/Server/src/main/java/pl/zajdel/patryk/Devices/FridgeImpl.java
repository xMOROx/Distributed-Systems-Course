package pl.zajdel.patryk.Devices;

import io.grpc.BindableService;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.Void;
import pl.zajdel.patryk.gen.SmartHome.*;
import pl.zajdel.patryk.utils.OperationHelper;

public class FridgeImpl extends SmartDeviceImpl implements FridgeGrpc.AsyncService, BindableService {

    private static final double CHANGE_TEMPERATURE_MIN_VALUE = 0.1;
    private static final double CHANGE_TEMPERATURE_MAX_VALUE = 1.0;
    private static final double CHANGE_TEMPERATURE_PROBABILITY = 0.3;
    private static double MIN_SUPPORTED_TEMPERATURE = -20;
    private static double MAX_SUPPORTED_TEMPERATURE = 20;
    protected Mode mode = Mode.ON;
    private float targetTemperature;
    private float currentTemperature;


    public FridgeImpl(float targetTemperature, float currentTemperature, String serverSocket) {
        super(serverSocket);
        this.targetTemperature = targetTemperature;
        this.currentTemperature = currentTemperature;
        this.serverSocket = serverSocket;
    }

    @Override
    public void setTargetTemperature(Temperature request, StreamObserver<Temperature> responseObserver) {
        if (!checkIfTemperatureInSupportedRange(request.getTemperature())) {
            logger.warning("Temperature out of range for fridge with server socket: " + serverSocket);
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Temperature out of range")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.TEMPERATURE_OUT_OF_SUPPORTED_RANGE, "Temperature out of range")));
            return;
        }

        targetTemperature = request.getTemperature();
        logger.info("Temperature set to: " + targetTemperature + " for fridge with server socket: " + serverSocket);

        responseObserver.onNext(Temperature.newBuilder().setTemperature(targetTemperature).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getTargetTemperature(Void request, StreamObserver<Temperature> responseObserver) {
        logger.info("Getting target temperature for fridge with server socket: " + serverSocket);
        responseObserver.onNext(Temperature.newBuilder().setTemperature(targetTemperature).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCurrentTemperature(Void request, StreamObserver<Temperature> responseObserver) {
        if (notifyIfInStandbyMode(responseObserver)) return;

        double temperatureDelta = Math.random() <= CHANGE_TEMPERATURE_PROBABILITY ?
                OperationHelper.getRandomDoubleFromRange(CHANGE_TEMPERATURE_MIN_VALUE, CHANGE_TEMPERATURE_MAX_VALUE) : 0;

        double missingTemperature = Math.abs(currentTemperature - targetTemperature);

        if (missingTemperature < temperatureDelta) {
            temperatureDelta = missingTemperature;
        }
        if (currentTemperature > targetTemperature) {
            temperatureDelta *= -1;
        }
        double newTemperature = currentTemperature + temperatureDelta;

        logger.info("Current temperature changed from: " + currentTemperature + " to: " + newTemperature + " for fridge with server socket: " + serverSocket);

        if (checkIfTemperatureInSupportedRange(newTemperature)) {
            currentTemperature = (float) newTemperature;
        }


        responseObserver.onNext(Temperature.newBuilder().setTemperature(currentTemperature).build());
        responseObserver.onCompleted();
    }

    private boolean checkIfTemperatureInSupportedRange(double temperature) {
        logger.info("Checking if temperature is in supported range for fridge with server socket: " + serverSocket);
        return OperationHelper.checkIfValueInRange(temperature, MIN_SUPPORTED_TEMPERATURE, MAX_SUPPORTED_TEMPERATURE);
    }

    @Override
    public ServerServiceDefinition bindService() {
        return FridgeGrpc.bindService(this);
    }
}
