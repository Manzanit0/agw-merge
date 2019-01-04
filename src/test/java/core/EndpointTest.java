package core;

import core.models.Request;
import core.models.Response;
import core.models.ResponseHeader;
import org.junit.Test;
import stubs.EndpointStub;

import static org.junit.Assert.assertEquals;

public class EndpointTest {
    @Test
    public void getsCorrectResponseForExistingMethod() {
        Endpoint endpoint = new EndpointStub();
        Request request = new Request("GET", "/false_endpoint", "HTTP/1.1");

        Response response = endpoint.getResponse(request);

        assertEquals(200, response.getStatusCode());
        assertEquals("OK", response.getReason());
        assertEquals("GET", response.getHeaders().get(ResponseHeader.ALLOW));
    }

    @Test
    public void getsNotAllowedForInexistentMethod() {
        Endpoint endpoint = new EndpointStub();
        Request request = new Request("POST", "/false_endpoint", "HTTP/1.1");

        Response response = endpoint.getResponse(request);

        assertEquals(405, response.getStatusCode());
        assertEquals("NOT ALLOWED", response.getReason());
        assertEquals("GET", response.getHeaders().get(ResponseHeader.ALLOW));
    }
}
