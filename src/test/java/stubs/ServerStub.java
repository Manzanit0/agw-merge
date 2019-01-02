package stubs;

import core.Server;
import java.net.ServerSocket;

public class ServerStub extends Server {
    private int requestsProcessed = 0;
    private int requestsToProcess = 0;

    public ServerStub(ServerSocket serverSocket) {
        super(serverSocket);
    }

    @Override
    protected void handleRequest() {
        requestsProcessed++;
        send("Default response");

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
