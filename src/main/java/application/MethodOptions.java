package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.Arrays;

public class MethodOptions extends Endpoint {
    public MethodOptions() {
        setAllowedMethodsHeader(Arrays.asList("GET", "HEAD", "OPTIONS"));
    }

    public String getUri() {
        return "/method_options";
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
}