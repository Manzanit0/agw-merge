package stubs;

import core.Connection;
import core.Router;
import core.Server;

public class ServerStub extends Server {
    private int counter = 0;
    private int amountOfRequestsToProcess;

    public ServerStub(Connection connection, Router router) {
        super(connection, router);
    }

    @Override
    protected boolean isRunning() {
        counter++;
        return counter <= amountOfRequestsToProcess;
    }

    public void setRequestsUntilShutdown(int amount) {
        amountOfRequestsToProcess = amount;
    }
}