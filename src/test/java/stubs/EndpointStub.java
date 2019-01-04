package stubs;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.Arrays;

public class EndpointStub extends Endpoint {
    public EndpointStub() {
        setAllowedMethodsHeader(Arrays.asList("GET"));
    }

    public String getUri() {
        return "/false_endpoint";
    }

    public Response get(Request request) {
        return Response.ok();
    }
}
