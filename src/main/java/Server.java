import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void start() {
        acceptConnection();
        handleMessages();
    }

    private void acceptConnection() {
        try {
            socket = serverSocket.accept();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void handleMessages() {
        String defaultMessage = "DEFAULT MESSAGE";

        try {
            byte[] encodedMessageBytes = defaultMessage.getBytes(StandardCharsets.UTF_8);
            socket.getOutputStream().write(encodedMessageBytes);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}