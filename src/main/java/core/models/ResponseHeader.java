package core.models;

public enum ResponseHeader {
    ALLOW("Allow"),
    SERVER("Server"),
    LOCATION("Location");

    private String value;

    ResponseHeader(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
