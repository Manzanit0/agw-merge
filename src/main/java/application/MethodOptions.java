package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.LinkedHashMap;
import java.util.Map;

public class MethodOptions extends Endpoint {
    public String getUri() {
        return "/method_options";
    }

    public Response getResponse(Request request) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Allow", "GET,HEAD,OPTIONS");

        return Response.ok()
                .setHeaders(headers);
    }
}