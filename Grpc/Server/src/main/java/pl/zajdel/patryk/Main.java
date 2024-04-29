package pl.zajdel.patryk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static List<Thread> servers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            servers.add(
                    new Thread(SmartHomeServer.createSmartHomeServer(i + 1))
            );
        }

        for (int i = 0; i < 5; i++) {
            servers.get(i).start();
        }
    }
}