package core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stubs.ServerSocketStub;
import stubs.SocketStub;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class ConnectionTest {
    private ServerSocketStub serverSocket;
    private SocketStub socket;
    private Connection connection;

    @Before
    public void init() throws IOException {
        socket = new SocketStub();
        serverSocket = new ServerSocketStub(5101);

        // Simulates the first accepted connection.
        serverSocket.setConnectionSocket(socket);

        connection = new Connection(serverSocket);
        connection.accept();
    }

    @After
    public void clean() throws IOException {
        connection.close();
        serverSocket.close();
    }

    @Test
    public void sendsMessages() {
        connection.send("A message in a socket.");

        ByteArrayOutputStream output = (ByteArrayOutputStream) socket.getOutputStream();
        assertEquals("A message in a socket.", output.toString());
    }

    @Test
    public void receivesMessages() {
        socket.setMockMessages("out", "in");

        String message = connection.receive();

        assertEquals("in", message);
    }

    @Test
    public void receivesMultilineMessages() {
        socket.setMockMessages("out", "in\nin2\nin3");

        String message = connection.receive();

        assertEquals("in\nin2\nin3", message);
    }
}
