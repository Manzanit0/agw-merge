import application.*;
import core.Connection;
import core.Router;
import core.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String... args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Connection conn = new Connection(serverSocket);
        Server server = new Server(conn, getDefaultRouter());

        System.out.println("Listening for connection on port 5000 ....");
        server.start();
    }


    private static Router getDefaultRouter() {
        return new Router()
                .addEndpoint(new Redirect())
                .addEndpoint(new MethodOptions())
                .addEndpoint(new MethodOptions2())
                .addEndpoint(new EchoBody())
                .addEndpoint(new SimpleGet())
                .addEndpoint(new GetWithBody());
    }
}
