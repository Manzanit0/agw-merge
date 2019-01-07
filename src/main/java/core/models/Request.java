package core.models;

import java.util.Map;

public class Request {
    private String method;
    private String uri;
    private String httpVersion;
    private Map<String, String> headers;
    private String body;

    public Request() {}

    public Request(String method, String uri, String httpVersion) {
        this.method = method;
        this.uri = uri;
        this.httpVersion = httpVersion;
    }

    public Request withMethod(String method) {
        this.method = method;
        return this;
    }

    public Request withUri(String uri) {
        this.uri = uri;
        return this;
    }

    public Request withHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
        return this;
    }

    public Request withBody(String body) {
        this.body = body;
        return this;
    }

    public Request withHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public Map getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
