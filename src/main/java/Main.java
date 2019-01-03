import application.*;
import core.Router;
import core.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String... args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Server server = new Server(serverSocket, getDefaultRouter());

        System.out.println("Listening for connection on port 5000 ....");
        server.start();
    }


    private static Router getDefaultRouter() {
        return new Router()
                .addEndpoint(new RedirectEndpoint())
                .addEndpoint(new MethodOptionsEndpoint())
                .addEndpoint(new MethodOptions2Endpoint())
                .addEndpoint(new EchoBodyEndpoint())
                .addEndpoint(new SimpleGetEndpoint())
                .addEndpoint(new GetWithBodyEndpoint());
    }
}
