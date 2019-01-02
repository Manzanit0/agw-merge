import stubs.ServerStub;
import stubs.ServerSocketStub;
import stubs.SocketStub;
import core.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static junit.framework.TestCase.assertEquals;

public class ServerTest {
    private ServerSocketStub serverSocket;
    private SocketStub socket;

    @Before
    public void init() throws IOException {
        socket = new SocketStub();
        serverSocket = new ServerSocketStub(5000);

        // Simulates the first accepted connection.
        serverSocket.setConnectionSocket(socket);
    }

    @After
    public void clean() throws IOException {
        serverSocket.close();
    }

    @Test
    public void sendsMessages() {
        Server server = new Server(serverSocket);
        server.acceptConnection();

        server.send("A message in a socket.");

        ByteArrayOutputStream output = (ByteArrayOutputStream) socket.getOutputStream();
        assertEquals("A message in a socket.", output.toString());
    }

    @Test
    public void receivesMessages() {
        Server server = new Server(serverSocket);
        server.acceptConnection();

        setMockMessages(socket, "out", "in");

        String message = server.receive();

        assertEquals("in", message);
    }

    @Test
    public void receivesMultilineMessages() {
        Server server = new Server(serverSocket);
        server.acceptConnection();

        setMockMessages(socket, "out", "in\nin2\nin3");

        String message = server.receive();

        assertEquals("in\nin2\nin3", message);
    }

    @Test
    public void handlesIncomingMessages() {
        ServerStub server = new ServerStub(serverSocket);
        server.setExchangedMessages(new String[]{ "First message" });

        server.start();

        ByteArrayOutputStream output = (ByteArrayOutputStream) socket.getOutputStream();
        assertEquals("Default response", output.toString());
    }

    private static void setMockMessages(SocketStub socketStub, String outMessage, String inMessage) {
        InputStream socketInput = new ByteArrayInputStream(inMessage.getBytes());
        socketStub.setInputStream(socketInput);

        OutputStream socketOutput = new ByteArrayOutputStream();

        try {
            socketOutput.write(outMessage.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        socketStub.setOutputStream(socketOutput);
    }
}
