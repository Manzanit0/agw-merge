package stubs;

import core.Connection;
import core.Server;

public class ServerStub extends Server {
    private int requestsProcessed = 0;
    private int requestsToProcess = 0;

    public ServerStub(Connection connection) {
        super(connection);
    }

    @Override
    protected void handleRequest() {
        requestsProcessed++;
        connection.send("Default response");

        if(requestsProcessed == requestsToProcess) {
            this.isRunning = false;
        }
    }

    public void setRequestsToProcess(int requestsToProcess) {
        this.requestsToProcess = requestsToProcess;
    }

    public int getRequestsProcessed() {
        return requestsProcessed;
    }
}
