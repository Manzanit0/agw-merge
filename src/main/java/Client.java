import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public String send(String message) {
        try {
            socket.getOutputStream()
                    .write(message.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return receive();
    }

    public String receive() {
        String data = "";

        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String line;
            while((line = reader.readLine()) != null) {
                data += line;
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return data;
    }
}
