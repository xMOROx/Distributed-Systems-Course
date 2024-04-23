package pl.zajdel.patryk;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import pl.zajdel.patryk.Devices.CO2LevelSensorImpl;
import pl.zajdel.patryk.Devices.FridgeImpl;
import pl.zajdel.patryk.Devices.FridgeWithIceCubeMakerImpl;
import pl.zajdel.patryk.Devices.FridgeWithShoppingListImpl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class SmartHomeServer {
    private static final Logger logger = Logger.getLogger(SmartHomeServer.class.getName());

    private final String address = "127.0.0.5";
    private final int port = 50051;
    private Server server;
    private SocketAddress socket;

    private SmartHomeServer() throws IllegalArgumentException, UnknownHostException {

        this.socket = new InetSocketAddress(InetAddress.getByName(address), port);

        this.server = NettyServerBuilder.forAddress(socket).executor(Executors.newFixedThreadPool(16))
                .addService(new CO2LevelSensorImpl(237))
                .addService(new FridgeImpl(5, 8))
                .addService(new FridgeWithIceCubeMakerImpl(5, 8, 42))
                .addService(new FridgeWithShoppingListImpl(5, 8))
                .build();
    }

    public static SmartHomeServer createSmartHomeServer() throws IOException, IllegalArgumentException {
        return new SmartHomeServer();
    }

    public void start() throws IOException {
        this.server.start();
        logger.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC server...");
                SmartHomeServer.this.stop();
                System.err.println("Server shut down.");
            }
        });
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

}
