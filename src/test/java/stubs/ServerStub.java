package stubs;

import core.Server;
import java.net.ServerSocket;

public class ServerStub extends Server {
    private String[] messages;

    public ServerStub(ServerSocket serverSocket) {
        super(serverSocket);
    }

    @Override
    protected void handleMessages() {
        for(String message : messages) {
            System.out.println(message);
            send("Default response");
        }
    }

    public void setExchangedMessages(String[] messages) {
        this.messages = messages;
    }
}
