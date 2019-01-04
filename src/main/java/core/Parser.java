package core;

import core.models.Request;

import java.util.LinkedHashMap;

public class Parser {

    public static Request parse(String request) {
        String[] lines = request.split("\n");
        String[] requestLine = lines[0].split(" ");

        String method = requestLine[0];
        String requestUri = requestLine[1];
        String httpVersion = requestLine[2];

        String[] parts = request.split("\r\n\r\n");

        LinkedHashMap<String, String> headers = parseHeader(parts[0]);
        String body = parts.length == 2 ? parts[1] : null;

        return new Request(method, requestUri, httpVersion)
                .setHeaders(headers)
                .setBody(body);
    }

    private static LinkedHashMap<String, String> parseHeader(String headers) {
        LinkedHashMap<String, String> headersMap = new LinkedHashMap<>();

        String[] headersArray = headers.split("\n");

        for(int i = 1; i < headersArray.length; i++) { // Skip first element -> HTTP requestLine.
            String[] header = headersArray[i].split(":");
            headersMap.put(header[0].trim(), header[1].trim());
        }

        return headersMap;
    }
}
