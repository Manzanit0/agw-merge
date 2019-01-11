package stubs;

import core.Router;
import core.models.Request;
import core.models.Response;

import java.util.LinkedList;

public class RouterStub extends Router {
    private LinkedList<Response> responses;
    private Request lastRequest;

    public RouterStub() {
        responses = new LinkedList<>();
    }

    @Override
    public Response getResponse(Request request) {
        lastRequest = request;

        Response response = responses.getFirst();
        responses.removeFirst();
        return response;
    }

    public void setResponses(LinkedList<Response> responses) {
        this.responses = responses;
    }

    public Request getLastRequest() {
        return lastRequest;
    }
}
