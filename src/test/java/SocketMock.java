import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketMock extends Socket {
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public SocketMock(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return outputStream;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return inputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
