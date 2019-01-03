package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.LinkedHashMap;
import java.util.Map;

public class MethodOptions2Endpoint extends Endpoint {
    @Override
    public String getUri() {
        return "/method_options2";
    }

    @Override
    public Response getResponse(Request request) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Allow", "GET,HEAD,OPTIONS,PUT,POST");

        return new Response("HTTP/1.1", "200", "OK", headers, "");
    }
}
