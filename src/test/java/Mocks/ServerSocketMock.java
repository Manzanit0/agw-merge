package Mocks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMock extends ServerSocket {
    private SocketMock socket;

    public ServerSocketMock(int port) throws IOException {
        super(port);
    }

    @Override
    public Socket accept() {
        return socket;
    }

    public void setConnectionSocket(SocketMock socket) {
        this.socket = socket;
    }
}
