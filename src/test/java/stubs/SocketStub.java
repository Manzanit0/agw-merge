package stubs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketStub extends Socket {
    private OutputStream outputStream;
    private InputStream inputStream;

    public SocketStub() {
        outputStream = new ByteArrayOutputStream();
        inputStream = new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setMockMessages(String outMessage, String inMessage) {
        InputStream socketInput = new ByteArrayInputStream(inMessage.getBytes());
        setInputStream(socketInput);

        OutputStream socketOutput = new ByteArrayOutputStream();

        try {
            socketOutput.write(outMessage.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        setOutputStream(socketOutput);
    }
}
