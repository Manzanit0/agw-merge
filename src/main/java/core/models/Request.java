package core.models;

import java.util.LinkedHashMap;

public final class Request {
    private final String method;
    private final String uri;
    private final String httpVersion;
    private final LinkedHashMap<String, String> headers;
    private final String body;

    public Request(String method, String uri, String httpVersion, LinkedHashMap<String, String> headers, String body) {
        this.method = method;
        this.uri = uri;
        this.httpVersion = httpVersion;
        this.headers = headers;
        this.body = body;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUri() {
        return this.uri;
    }

    public String getHttpVersion() { return this.httpVersion; }

    public LinkedHashMap getHeaders() {
        return this.headers;
    }

    public String getBody() {
        return this.body;
    }
}
