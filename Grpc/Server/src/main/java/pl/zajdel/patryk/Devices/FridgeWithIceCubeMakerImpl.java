package pl.zajdel.patryk.Devices;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import pl.zajdel.patryk.gen.SmartHome.FridgeWithIceCubeMakerGrpc;
import pl.zajdel.patryk.gen.SmartHome.IceCubesMaker;

public class FridgeWithIceCubeMakerImpl extends FridgeWithIceCubeMakerGrpc.FridgeWithIceCubeMakerImplBase
{


    @Override
    public void getIceCubesMakerCapacity(Empty request, StreamObserver<IceCubesMaker> responseObserver) {
        super.getIceCubesMakerCapacity(request, responseObserver);
    }

    @Override
    public void getIceCubes(IceCubesMaker request, StreamObserver<IceCubesMaker> responseObserver) {
        super.getIceCubes(request, responseObserver);
    }

    @Override
    public void getIceCubesCount(Empty request, StreamObserver<IceCubesMaker> responseObserver) {
        super.getIceCubesCount(request, responseObserver);
    }
}
