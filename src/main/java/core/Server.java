package core;

import core.models.Request;
import core.models.Response;

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