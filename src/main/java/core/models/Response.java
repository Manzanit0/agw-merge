package core.models;

import java.util.Map;
import java.util.Map.Entry;

public class Response {
    private static final String HTTP_VERSION = "HTTP/1.1";

    private int statusCode;
    private String reason;
    private Map<String, String> headers;
    private String body;

    public Response(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
        this.body = "";
    }

    public static Response notFound() {
        return new Response(404, "NOT FOUND");
    }

    public static Response ok() {
        return new Response(200, "OK");
    }

    public static Response redirect() {
        return new Response(301, "REDIRECT");
    }

    public static Response notAllowed() {
        return new Response(405, "NOT ALLOWED");
    }

    public Response setBody(String body) {
        this.body = body;
        return this;
    }

    public Response setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public String getHttpVersion() {
        return HTTP_VERSION;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getHttpVersion() + " " + getStatusCode() + " " + getReason() + "\n"
                + getFormattedHeaders()
                + getFormattedBody();
    }

    private String getFormattedHeaders() {
        if (getHeaders() == null || getHeaders().size() == 0) return "";

        StringBuilder formattedHeaders = new StringBuilder();

        for (Entry<String, String> entry : getHeaders().entrySet()) {
            formattedHeaders.append(
                    String.format("%s: %s%n", entry.getKey(), entry.getValue()));
        }

        return formattedHeaders.toString();
    }

    private String getFormattedBody() {
        return getBody() == null || getBody().isEmpty() ? "" : "\n" + getBody().trim();
    }
}
