package core;

import core.models.Request;
import core.models.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;

    protected boolean isRunning = true;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void start() {
        while(isRunning()) {
            acceptConnection();
            handleRequest();
            closeConnection();
        }
    }

    public void acceptConnection() {
        try {
            socket = serverSocket.accept();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void handleRequest() {
        String request = receive();

        Request requestModel = Parser.parse(request);

        // TODO - Here we would have to multiplex between registered endpoints.
        Response responseModel = new Endpoint().getResponse(requestModel);

        send(responseModel.toString());
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

    private void closeConnection() {
        try {
            socket.close();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private boolean isRunning() {
        return isRunning;
    }
}