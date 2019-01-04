package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;
import core.models.ResponseHeader;

public class Redirect extends Endpoint {
    public String getUri() {
        return "/redirect";
    }

    @Override
    public Response get(Request request) {
        return Response.redirect()
                .addHeader(ResponseHeader.LOCATION, "http://0.0.0.0:5000/simple_get");
    }
}