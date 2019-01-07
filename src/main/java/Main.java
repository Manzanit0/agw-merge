import application.*;
import core.Router;
import core.Server;

public class Main {

    public static void main(String... args) {
        Server server = Server.defaultServer();
        configureRouter(server.getRouter());

        server.start();
    }

    private static void configureRouter(Router router) {
        router.add(new Redirect())
                .add(new MethodOptions())
                .add(new MethodOptions2())
                .add(new EchoBody())
                .add(new SimpleGet())
                .add(new GetWithBody());
    }
}
