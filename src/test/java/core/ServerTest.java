package core;

import org.junit.Test;
import stubs.ConnectionStub;
import stubs.RouterStub;

import java.util.LinkedList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

public class ServerTest {
    @Test
    public void createsDefaultRouterWithoutExceptions() {
        Server server = Server.defaultServer(5202);
        assertNotEquals(null, server);
        assertNotEquals(null, server.getRouter());
    }

    @Test
    public void uponHandlingNonHttpRequestReturnsBadRequest() {
        ConnectionStub connectionStub = createConnectionStubWithBadMessages();
        RouterStub routerStub = new RouterStub();
        Server server = new Server(connectionStub, routerStub);

        server.handleRequest();

        assertTrue(connectionStub.getLastResponse().contains("BAD REQUEST"));
    }

    private ConnectionStub createConnectionStubWithBadMessages() {
        ConnectionStub connectionStub = new ConnectionStub(null);

        LinkedList<String> messages = new LinkedList<>();
        messages.add("some-non-http-message");
        connectionStub.setIncomingRequests(messages);

        return connectionStub;
    }
}