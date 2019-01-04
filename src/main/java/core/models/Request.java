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

    public Request setMethod(String method) {
        this.method = method;
        return this;
    }

    public Request setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public Request setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
        return this;
    }

    public Request setBody(String body) {
        this.body = body;
        return this;
    }

    public Request setHeaders(Map<String, String> headers) {
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
