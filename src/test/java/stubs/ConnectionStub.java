package stubs;

import core.Connection;

import java.net.ServerSocket;
import java.util.LinkedList;

public class ConnectionStub extends Connection {
    private LinkedList<String> receivedRequests;
    private String lastResponse;

    public ConnectionStub(ServerSocket serverSocket) {
        super(serverSocket);
    }

    @Override
    public void accept() {
        // Do nothing -> We don't want to deal with sockets here.
    }

    @Override
    public void close() {
        // Likewise.
    }

    @Override
    public void send(String message) {
        lastResponse = message;
    }

    @Override
    public String receive() {
        String message = receivedRequests.getFirst();
        receivedRequests.removeFirst();
        return message;
    }

    public void setIncomingRequests(LinkedList<String> messages) {
        this.receivedRequests = messages;
    }

    public String getLastResponse() {
        return lastResponse;
    }
}
