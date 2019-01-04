package core;

import core.models.Request;
import core.models.Response;
import core.models.ResponseHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Endpoint {
    private List<String> allowedMethods = new ArrayList<>();

    public abstract String getUri();

    protected Response post(Request request) {
        throw new UnsupportedOperationException();
    }

    protected Response get(Request request) {
        throw new UnsupportedOperationException();
    }

    protected Response put(Request request) {
        throw new UnsupportedOperationException();
    }

    protected Response head(Request request) {
        throw new UnsupportedOperationException();
    }

    protected Response options(Request request) {
        throw new UnsupportedOperationException();
    }

    public Response getResponse(Request request) {
        Response response;

        try {
            response = handleRequest(request)
                    .addAllHeaders(getDefaultHeaders());
        }
        catch (UnsupportedOperationException ex) {
            response = Response.notAllowed()
                .addAllHeaders(getDefaultHeaders());
        }

        return response;
    }

    private Response handleRequest(Request request) {
        Response res;

        switch (request.getMethod()) {
            case "POST":
                res = post(request);
                break;
            case "GET":
                res = get(request);
                break;
            case "PUT":
                res = put(request);
                break;
            case "HEAD":
                res = head(request);
                break;
            case "OPTIONS":
                res = options(request);
                break;
            default :
                res = Response.badRequest();
        }

        return res;
    }

    private Map<ResponseHeader, String> getDefaultHeaders() {
        return Map.of(
                ResponseHeader.SERVER, "A Javier Server 1.0",
                ResponseHeader.ALLOW, String.join(",", allowedMethods)
        );
    }

    protected void setAllowedMethodsHeader(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }
}