package pl.zajdel.patryk;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import pl.zajdel.patryk.Devices.*;
import pl.zajdel.patryk.utils.OperationHelper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class SmartHomeServer implements Runnable {
    private static final Logger logger = Logger.getLogger(SmartHomeServer.class.getName());

    private final String address = "127.0.0.!!";
    private final int port = 50051;
    private int serverId;
    private Server server;
    private SocketAddress socket;

    private SmartHomeServer(int serverId) throws IllegalArgumentException, UnknownHostException {
        this.serverId = serverId;
        this.socket = new InetSocketAddress(InetAddress.getByName(address.replace("!!", String.valueOf(serverId))), port);

        String socketAsString = socket.toString();
        
        this.server = NettyServerBuilder
                .forAddress(socket)
                .executor(Executors.newFixedThreadPool(16))
                .addService(new SmartDeviceImpl(socketAsString))
                .addService(new CO2LevelSensorImpl(OperationHelper.getRandomIntFromRange(200, 300), socketAsString))
                .addService(new FridgeImpl(5, 8, socketAsString))
                .addService(new FridgeWithIceCubeMakerImpl(5, 8, 42, socketAsString))
                .addService(new FridgeWithShoppingListImpl(5, 7, socketAsString))
                .build();
    }

    public static SmartHomeServer createSmartHomeServer(int serverId) throws IOException, IllegalArgumentException {
        return new SmartHomeServer(serverId);
    }

    private void start() throws IOException {
        this.server.start();
        logger.info("Server started, listening on a socket " + address.replace("!!", String.valueOf(this.serverId)) + ":" + port);

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

    @Override
    public void run() {
        try {
            this.start();
            this.blockUntilShutdown();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while launching server on socket " + address.replace("!!", String.valueOf(this.serverId)) + ":" + port);
        }

    }
}
