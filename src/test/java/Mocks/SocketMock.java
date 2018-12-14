package Mocks;

import java.io.*;
import java.net.Socket;

public class SocketMock extends Socket {
    private OutputStream outputStream;
    private InputStream inputStream;

    public SocketMock() {
        outputStream = new ByteArrayOutputStream();
        inputStream = new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
