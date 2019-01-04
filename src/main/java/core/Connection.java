package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Connection {
    private ServerSocket serverSocket;
    private Socket socket;

    public Connection(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void acceptConnection() {
        try {
            socket = serverSocket.accept();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void send(String message) {
        try {
            socket.getOutputStream()
                    .write(message.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String receive() {
        String data;

        try {
            data = readAllBytes(socket.getInputStream());
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return data;
    }

    private String readAllBytes(InputStream stream) throws IOException {
        StringBuilder data = new StringBuilder();

        // available only returns a value after reading at least 1 character -> do/while.
        do {
            data.append((char) stream.read());
        } while (stream.available() > 0);

        return data.toString().trim();
    }

    public void closeConnection() {
        try {
            socket.close();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
