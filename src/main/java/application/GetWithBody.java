package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

import java.util.Arrays;

public class GetWithBody extends Endpoint {
    public GetWithBody() {
        setAllowedMethodsHeader(Arrays.asList("HEAD", "OPTIONS"));
    }

    public String getUri() {
        return "/get_with_body";
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
