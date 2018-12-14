package Mocks;

import core.Server;
import java.net.ServerSocket;

public class ServerMock extends Server {
    private String[] messages;

    public ServerMock(ServerSocket serverSocket) {
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
