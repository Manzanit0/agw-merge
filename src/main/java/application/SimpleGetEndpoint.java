package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

public class SimpleGetEndpoint extends Endpoint {
    public String getUri() {
        return "/simple_get";
    }

    public Response getResponse(Request request) {
        return new Response("HTTP/1.1", "200", "OK", null, "");
    }
}
