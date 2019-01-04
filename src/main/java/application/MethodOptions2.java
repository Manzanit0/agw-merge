package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.Arrays;

public class MethodOptions2 extends Endpoint {
    public MethodOptions2() {
        setAllowedMethodsHeader(Arrays.asList("GET", "HEAD", "OPTIONS", "PUT", "POST"));
    }

    @Override
    public String getUri() {
        return "/method_options2";
    }

    @Override
    protected Response get(Request request) {
        return Response.ok();
    }

    @Override
    protected Response head(Request request) {
        return Response.ok();
    }

    @Override
    protected Response options(Request request) {
        return Response.ok();
    }

    @Override
    protected Response put(Request request) {
        return Response.ok();
    }

    @Override
    protected Response post(Request request) {
        return Response.ok();
    }
}
