package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.LinkedHashMap;
import java.util.Map;

public class Redirect extends Endpoint {
    public String getUri() {
        return "/redirect";
    }

    public Response getResponse(Request request) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Location", "http://0.0.0.0:5000/simple_get");

        return Response.redirect()
                .setHeaders(headers);
    }
}