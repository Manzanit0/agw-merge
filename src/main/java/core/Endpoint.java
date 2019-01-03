package core;

import core.models.Request;
import core.models.Response;

public class Endpoint {
    public Response getResponse(Request request) {
        return new Response();
    }
}
