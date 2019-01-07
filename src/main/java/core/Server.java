package core;

import core.models.Request;
import core.models.Response;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    protected Connection connection;
    protected boolean isRunning = true;
    private Router router;

    public Server(Connection connection) {
        this.connection = connection;
        this.router = new Router();
    }

    public Server(Connection connection, Router router) {
        this.connection = connection;
        this.router = router;
    }

    public static Server defaultServer() {
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection conn = new Connection(serverSocket);
        Router router = new Router();
        return new Server(conn, router);
    }

    public Router getRouter() {
        return router;
    }

    public void start() {
        while (isRunning()) {
            connection.acceptConnection();
            handleRequest();
            connection.closeConnection();
        }
    }

    protected void handleRequest() {
        String request = connection.receive();
        Request requestModel = Parser.parse(request);
        Response responseModel = router.getResponse(requestModel);
        connection.send(responseModel.toString());
    }

    private boolean isRunning() {
        return isRunning;
    }
}