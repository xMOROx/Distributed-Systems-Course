package pl.zajdel.patryk.utils;

import io.grpc.Metadata;
import io.grpc.protobuf.ProtoUtils;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.ErrorResponse;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OperationHelper {
    private static final Random random = new Random();

    // Both inclusive
    public static int getRandomIntFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    // Both inclusive
    public static double getRandomDoubleFromRange(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    public static boolean checkIfValueInRange(double value, double min, double max) {
        return min <= value && value <= max;
    }

    public static Metadata composeErrorResponse(Error error, String message) {
        Metadata.Key<ErrorResponse> errorResponseKey = ProtoUtils.keyForProto(ErrorResponse.getDefaultInstance());

        ErrorResponse errorResponse = ErrorResponse.newBuilder()
                .setError(error)
                .setMessage(message)
                .build();

        Metadata metadata = new Metadata();
        metadata.put(errorResponseKey, errorResponse);

        return metadata;
    }
}
