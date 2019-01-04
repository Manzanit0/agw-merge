package core;

import core.models.Request;
import core.models.Response;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private Endpoint defaultEndpoint;
    private Map<String, Endpoint> endpoints;

    public Router() {
        defaultEndpoint = new DefaultEndpoint();
        endpoints = new HashMap<>();
    }

    public Response getResponse(Request request) {
        Endpoint endpoint = endpoints.getOrDefault(request.getUri(), defaultEndpoint);
        return endpoint.getResponse(request);
    }

    public Router addEndpoint(Endpoint endpoint) {
        endpoints.put(endpoint.getUri(), endpoint);
        return this;
    }

    public Map<String, Endpoint> getEndpoints() {
        return endpoints;
    }

    public class DefaultEndpoint extends Endpoint {
        @Override
        public String getUri() {
            return "";
        }

        @Override
        public Response getResponse(Request request) {
            return Response.notFound();
        }
    }
}