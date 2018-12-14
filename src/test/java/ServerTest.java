import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ServerTest {
    private ServerSocketMock serverSocket;
    private SocketMock socket;
    private SocketMock clientSocket;

    @Before
    public void init() throws IOException {
        socket = new SocketMock("0.0.0.0", 5000);
        serverSocket = new ServerSocketMock(5000);

        // Simulates the first accepted connection.
        serverSocket.setConnectionSocket(socket);

        // Messages exchanged with the first connection.
        setMockMessages(socket, "XXX", "XXX");

        clientSocket = new SocketMock("0.0.0.0", 5000);
    }

    @After
    public void clean() throws IOException {
        serverSocket.close();
    }

    @Test
    public void acceptsIncomingConnections() throws IOException {
        Server server = new Server(serverSocket);
        server.start();

        ByteArrayOutputStream output = (ByteArrayOutputStream) socket.getOutputStream();
        assertFalse(output.toString().isEmpty());
    }

    @Test
    public void receivesIncomingMessages() {
        Server server = new Server(serverSocket);
        server.start();

        Client client = new Client(clientSocket);
        setMockMessages(clientSocket, "Message to send", "Message to receive");

        String response = client.send("Message to send");

        assertTrue(response.contains("Message to receive"));
    }


    private static void setMockMessages(SocketMock socketMock, String outMessage, String inMessage) {
        InputStream socketInput = new ByteArrayInputStream(inMessage.getBytes());
        socketMock.setInputStream(socketInput);

        OutputStream socketOutput = new ByteArrayOutputStream();

        try {
            socketOutput.write(outMessage.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        socketMock.setOutputStream(socketOutput);
    }
}
