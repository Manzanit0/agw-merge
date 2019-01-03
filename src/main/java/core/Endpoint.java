package core;

import core.models.Request;
import core.models.Response;

import java.util.LinkedHashMap;
import java.util.Map;

public class Endpoint {
    public Response getResponse(Request request) {
        if(request.getUri().equals("/redirect")) {
            Map<String, String> headers = new LinkedHashMap<>();
            headers.put("Location", "http://0.0.0.0:5000/simple_get");
            return new Response("HTTP/1.1", "301", "REDIRECT", headers, "");
        }

        if(request.getUri().equals("/method_options")) {
            Map<String, String> headers = new LinkedHashMap<>();
            headers.put("Allow", "GET,HEAD,OPTIONS");
            return new Response("HTTP/1.1", "200", "OK", headers, "");
        }

        if(request.getUri().equals("/method_options2")) {
            Map<String, String> headers = new LinkedHashMap<>();
            headers.put("Allow", "GET,HEAD,OPTIONS,PUT,POST");
            return new Response("HTTP/1.1", "200", "OK", headers, "");
        }

        if(request.getUri().equals("/get_with_body")) {
            Map<String, String> headers = new LinkedHashMap<>();
            headers.put("Allow", "HEAD,OPTIONS");

            if(request.getMethod().equals("HEAD") || request.getMethod().equals("OPTIONS")) {
                return new Response("HTTP/1.1", "200", "OK", headers, "");
            }
            else {
                return new Response("HTTP/1.1", "405", "OK", headers, "");
            }
        }

        if(request.getUri().equals("/not_found_resource")) {
            return new Response("HTTP/1.1", "404", "NOT FOUND", null, "");
        }

        if(request.getUri().equals("/echo_body")) {
            return new Response("HTTP/1.1", "200", "NOT FOUND", null, request.getBody());
        }

        return new Response("HTTP/1.1", "200", "OK", null, "");
    }
}
