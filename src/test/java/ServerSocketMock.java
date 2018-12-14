import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMock extends ServerSocket {
    private int port;
    private SocketMock socket;

    public ServerSocketMock(int port) throws IOException {
        super(port);
        this.port = port;
    }

    @Override
    public Socket accept() throws IOException {
        return socket;
    }

    public void setConnectionSocket(SocketMock socket) {
        this.socket = socket;
    }
}
