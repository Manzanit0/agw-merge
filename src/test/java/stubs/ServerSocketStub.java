package stubs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketStub extends ServerSocket {
    private SocketStub socket;

    public ServerSocketStub(int port) throws IOException {
        super(port);
    }

    @Override
    public Socket accept() {
        return socket;
    }

    public void setConnectionSocket(SocketStub socket) {
        this.socket = socket;
    }
}
