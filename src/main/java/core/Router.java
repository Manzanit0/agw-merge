package core;

import core.models.Request;
import core.models.Response;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private Map<String, Endpoint> endpoints;

    public Router() {
        endpoints = new HashMap<>();
    }

    public Response getResponse(Request request) {
        if(!endpoints.containsKey(request.getUri())) return Response.notFound();

        Endpoint endpoint = endpoints.get(request.getUri());
        return endpoint.getResponse(request);
    }

    public Router addEndpoint(Endpoint endpoint) {
        endpoints.put(endpoint.getUri(), endpoint);
        return this;
    }

    public Map<String, Endpoint> getEndpoints() {
        return endpoints;
    }
}