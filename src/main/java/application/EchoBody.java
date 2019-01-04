package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

public class EchoBody extends Endpoint {
    @Override
    public String getUri() {
        return "/echo_body";
    }

    @Override
    protected Response post(Request request) {
        return Response.ok()
                .setBody(request.getBody());
    }
}
