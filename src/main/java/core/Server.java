package core;

import core.models.Request;
import core.models.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String data = "";

        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String line;
            while(reader.ready() && (line = reader.readLine()) != null) {
                data += line + "\n";
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return data.trim();
    }

    private void closeConnection() {
        try {
            socket.close();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isRunning() {
        return isRunning;
    }
}