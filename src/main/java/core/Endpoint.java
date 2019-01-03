package core;

import core.models.Request;
import core.models.Response;

public abstract class Endpoint {
    public abstract String getUri();

    public abstract Response getResponse(Request request);
}