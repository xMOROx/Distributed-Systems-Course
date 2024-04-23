package pl.zajdel.patryk.Devices;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.FridgeGrpc;
import pl.zajdel.patryk.gen.SmartHome.Temperature;
import pl.zajdel.patryk.utils.OperationHelper;

public class FridgeImpl extends SmartDeviceImpl implements FridgeGrpc.AsyncService {

    private static final double CHANGE_TEMPERATURE_MIN_VALUE = 0.1;
    private static final double CHANGE_TEMPERATURE_MAX_VALUE = 1.0;
    private static final double CHANGE_TEMPERATURE_PROBABILITY = 0.3;
    private static double MIN_SUPPORTED_TEMPERATURE = -20;
    private static double MAX_SUPPORTED_TEMPERATURE = 20;
    private float targetTemperature;
    private float currentTemperature;

    public FridgeImpl(float targetTemperature, float currentTemperature) {
        this.targetTemperature = targetTemperature;
        this.currentTemperature = currentTemperature;
    }

    @Override
    public void setTargetTemperature(Temperature request, StreamObserver<Temperature> responseObserver) {
        if (!checkIfTemperatureInSupportedRange(request.getTemperature())) {
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Temperature out of range")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.TEMPERATURE_OUT_OF_SUPPORTED_RANGE, "Temperature out of range")));
            return;
        }
        targetTemperature = request.getTemperature();
        responseObserver.onNext(Temperature.newBuilder().setTemperature(targetTemperature).build());
    }

    @Override
    public void getTargetTemperature(Empty request, StreamObserver<Temperature> responseObserver) {
        responseObserver.onNext(Temperature.newBuilder().setTemperature(targetTemperature).build());
    }

    @Override
    public void getCurrentTemperature(Empty request, StreamObserver<Temperature> responseObserver) {
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
        if (checkIfTemperatureInSupportedRange(newTemperature)) {
            currentTemperature = (float) newTemperature;
        }

        responseObserver.onNext(Temperature.newBuilder().setTemperature(currentTemperature).build());
    }

    private boolean checkIfTemperatureInSupportedRange(double temperature) {
        return OperationHelper.checkIfValueInRange(temperature, MIN_SUPPORTED_TEMPERATURE, MAX_SUPPORTED_TEMPERATURE);
    }
}
