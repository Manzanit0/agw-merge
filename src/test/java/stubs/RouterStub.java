package stubs;

import core.Router;
import core.models.Request;
import core.models.Response;

public class RouterStub extends Router {
    @Override
    public Response getResponse(Request request) {
        return Response.ok();
    }
}
