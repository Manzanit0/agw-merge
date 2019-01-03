package core;

import core.models.Request;
import core.models.Response;

public class Endpoint {
    public Response getResponse(Request request) {
        if(request.getUri().equals("/not_found_resource")) {
            return new Response("HTTP/1.1", "404", "NOT FOUND", null, "");
        }

        if(request.getUri().equals("/echo_body")) {
            return new Response("HTTP/1.1", "200", "NOT FOUND", null, request.getBody());
        }

        return new Response("HTTP/1.1", "200", "OK", null, "");
    }
}
