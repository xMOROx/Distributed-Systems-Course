package pl.zajdel.patryk;

public class Main {
    public static void main(String[] args) {
        try {
            SmartHomeServer smartHomeServer = SmartHomeServer.createSmartHomeServer();
            smartHomeServer.start();
            smartHomeServer.blockUntilShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}