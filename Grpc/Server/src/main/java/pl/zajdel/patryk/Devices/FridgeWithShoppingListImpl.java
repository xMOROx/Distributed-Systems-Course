package pl.zajdel.patryk.Devices;

import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.Void;
import pl.zajdel.patryk.gen.SmartHome.*;
import pl.zajdel.patryk.utils.OperationHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FridgeWithShoppingListImpl extends FridgeImpl implements FridgeWithShoppingListGrpc.AsyncService {
    private final List<ShoppingListRecord> shoppingList = new ArrayList<>();

    public FridgeWithShoppingListImpl(float targetTemperature, float currentTemperature, String socket) {
        super(targetTemperature, currentTemperature, socket);
    }

    @Override
    public void getShoppingList(Void request, StreamObserver<OrderedShoppingListRecord> responseObserver) {
        if (notifyIfInStandbyMode(responseObserver)) return;

        logger.info("Getting shopping list for fridge with server socket: " + serverSocket);

        responseObserver.onNext(getOrderedShoppingListRecords());
        responseObserver.onCompleted();
    }

    @Override
    public void addShoppingListRecord(ShoppingListRecord request, StreamObserver<ShoppingListRecord> responseObserver) {
        if (notifyIfInStandbyMode(responseObserver)) return;

        logger.info("Adding shopping list record for fridge with server socket: " + serverSocket);
        logger.info("Shopping list record: " + request.toString());

        shoppingList.add(request);
        responseObserver.onNext(request);
        responseObserver.onCompleted();

    }


    @Override
    public void removeShoppingListRecord(FridgeRemoveShopping request, StreamObserver<ShoppingListRecord> responseObserver) {
        if (notifyIfInStandbyMode(responseObserver)) return;

        if (request.getId() < 0 || request.getId() >= shoppingList.size()) {
            logger.warning("Requested shopping list record not found for fridge with server socket: " + serverSocket);
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Requested shopping list record not found")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.INDEX_OUT_OF_LIST_RANGE, "Requested shopping list record not found"))
            );
            return;
        }
        ShoppingListRecord removedRecord = shoppingList.remove(request.getId());

        logger.info("Removing shopping list record with id " + request.getId() + " for fridge with server socket: " + serverSocket);

        responseObserver.onNext(removedRecord);
        responseObserver.onCompleted();
    }

    private OrderedShoppingListRecord getOrderedShoppingListRecords() {
        ShoppingListRecordWithId[] shoppingListRecordWithId =
                IntStream.range(0, shoppingList.size())
                        .mapToObj(i -> ShoppingListRecordWithId.newBuilder()
                                .setId(i)
                                .setShoppingListRecord(shoppingList.get(i))
                                .build())
                        .toArray(ShoppingListRecordWithId[]::new);
        return OrderedShoppingListRecord.newBuilder()
                .addAllShoppingListRecord(List.of(shoppingListRecordWithId))
                .build();
    }

    @Override
    public ServerServiceDefinition bindService() {
        return FridgeWithShoppingListGrpc.bindService(this);
    }
}
