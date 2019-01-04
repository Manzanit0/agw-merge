package stubs;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

public class EndpointStub extends Endpoint {
    public String getUri() {
        return "/false_endpoint";
    }

    public Response getResponse(Request request) {
        return Response.ok();
    }
}
