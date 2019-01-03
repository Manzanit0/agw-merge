package core.models;

import java.util.Map;
import java.util.Map.Entry;

public final class Response {
    private final String httpVersion;
    private final String statusCode;
    private final String reason;
    private final Map<String, String> headers;
    private final String body;

    public Response(String httpVersion,
                    String statusCode,
                    String reason,
                    Map<String, String> headers,
                    String body) {
        this.httpVersion = httpVersion;
        this.statusCode = statusCode;
        this.reason = reason;
        this.headers = headers;
        this.body = body;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public String getStatusCode() {
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
