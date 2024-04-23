package pl.zajdel.patryk.Devices;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.Error;
import pl.zajdel.patryk.gen.SmartHome.*;
import pl.zajdel.patryk.utils.OperationHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FridgeWithShoppingListImpl extends FridgeImpl implements FridgeWithShoppingListGrpc.AsyncService {
    private final List<ShoppingListRecord> shoppingList = new ArrayList<>();

    public FridgeWithShoppingListImpl(float targetTemperature, float currentTemperature) {
        super(targetTemperature, currentTemperature);
    }

    @Override
    public void getShoppingList(Empty request, StreamObserver<OrderedShoppingListRecord> responseObserver) {
    }

    @Override
    public void addShoppingListRecord(ShoppingListRecord request, StreamObserver<ShoppingListRecord> responseObserver) {
        shoppingList.add(request);
        responseObserver.onNext(request);
        responseObserver.onCompleted();

    }

    @Override
    public void removeShoppingListRecord(FridgeRemoveShopping request, StreamObserver<ShoppingListRecord> responseObserver) {
        if (request.getId() < 0 || request.getId() >= shoppingList.size()) {
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Requested shopping list record not found")
                            .asRuntimeException(OperationHelper.composeErrorResponse(Error.INDEX_OUT_OF_LIST_RANGE, "Requested shopping list record not found"))
            );
            return;
        }
        ShoppingListRecord removedRecord = shoppingList.remove(request.getId());
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
}
