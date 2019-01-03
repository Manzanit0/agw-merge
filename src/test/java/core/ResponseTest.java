package core;

import core.models.Response;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ResponseTest  {
    @Test
    public void hasValidStatusLineInformation() {
        Response res = new Response("HTTP/1.1", "200", "OK", null, null);

        assertEquals("HTTP/1.1", res.getHttpVersion());
        assertEquals("200", res.getStatusCode());
        assertEquals("OK", res.getReason());
    }

    @Test
    public void buildsResponseBasicResponse() {
        Response res = new Response("HTTP/1.1", "200", "OK", null, null);

        assertEquals("HTTP/1.1 200 OK\n", res.toString());
    }

    @Test
    public void buildsResponseWithBody() {
        Response res = new Response("HTTP/1.1", "200", "OK", null, "some body");

        assertEquals("HTTP/1.1 200 OK\n\nsome body", res.toString());
    }

    @Test
    public void buildsResponseWithHeaders() {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("key1", "value1");
        headers.put("key2", "value2");
        Response res = new Response("HTTP/1.1", "200", "OK", headers, "some body");

        assertEquals("HTTP/1.1 200 OK\nkey1: value1\nkey2: value2\n\nsome body", res.toString());
    }
}