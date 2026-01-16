package genericContactList.models;

public class NoteContext {
    private final String key;
    private final String value;

    public NoteContext(String key, String value) {
        this.key = key.toLowerCase();
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

