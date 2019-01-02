import core.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {

    public static void main(String... args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Server server = new Server(serverSocket);

        System.out.println("Listening for connection on port 5000 ....");
        server.start();
    }
}
