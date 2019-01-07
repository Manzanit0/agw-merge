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

    private int portNumber = 5000;
    private ServerSocketStub serverSocket;
    private SocketStub socket;

    @Before
    public void init() throws IOException {
        socket = new SocketStub();
        serverSocket = new ServerSocketStub(portNumber++);

        // Simulates the first accepted connection.
        serverSocket.setConnectionSocket(socket);
    }

    @After
    public void clean() throws IOException {
        serverSocket.close();
    }

    @Test
    public void sendsMessages() {
        Connection connection = new Connection(serverSocket);
        connection.acceptConnection();

        connection.send("A message in a socket.");

        ByteArrayOutputStream output = (ByteArrayOutputStream) socket.getOutputStream();
        assertEquals("A message in a socket.", output.toString());
    }

    @Test
    public void receivesMessages() {
        Connection connection = new Connection(serverSocket);
        connection.acceptConnection();

        socket.setMockMessages("out", "in");

        String message = connection.receive();

        assertEquals("in", message);
    }

    @Test
    public void receivesMultilineMessages() {
        Connection connection = new Connection(serverSocket);
        connection.acceptConnection();

        socket.setMockMessages("out", "in\nin2\nin3");

        String message = connection.receive();

        assertEquals("in\nin2\nin3", message);
    }
}
