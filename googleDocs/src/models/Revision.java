package googleDocs.src.models;

import java.time.LocalDateTime;

public class Revision {
    private String change;
    private LocalDateTime timestamp;

    public Revision(String change) {
        this.change = change;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return timestamp + " - " + change;
    }
}

