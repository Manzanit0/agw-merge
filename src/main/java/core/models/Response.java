package core.models;

import java.util.Map;
import java.util.Map.Entry;

public class Response {
    private static final String HTTP_VERSION = "HTTP/1.1";

    private int statusCode;
    private String reason;
    private Map<String, String> headers;
    private String body;

    public Response(int statusCode, String reason, Map<String, String> headers, String body) {
        this(statusCode, reason);
        this.headers = headers;
        this.body = body;
    }

    public Response(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public static Response notFound() {
        return new Response(404, "NOT FOUND");
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
