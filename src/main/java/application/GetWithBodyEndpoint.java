package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.LinkedHashMap;
import java.util.Map;

public class GetWithBodyEndpoint extends Endpoint {
    public String getUri() {
        return "/get_with_body";
    }

    public Response getResponse(Request request) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Allow", "HEAD,OPTIONS");

        if(request.getMethod().equals("HEAD") || request.getMethod().equals("OPTIONS")) {
            return Response.ok()
                    .setHeaders(headers);
        }

        return Response.notAllowed()
                .setHeaders(headers);
    }
}
