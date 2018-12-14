package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public void acceptConnection() {
        try {
            socket = serverSocket.accept();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void handleMessages() {
        String receivedMessage;
        while((receivedMessage = receive()) != null) {
            System.out.println(receivedMessage);
            send("Default response");
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
        String data = "";

        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String line;
            while((line = reader.readLine()) != null) {
                data += line + "\n";
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return data.trim();
    }
}