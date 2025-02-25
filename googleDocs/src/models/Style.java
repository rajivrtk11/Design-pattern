package googleDocs.src.models;

public class Style {
    private boolean bold;
    private boolean italic;
    private String color;

    public Style(boolean bold, boolean italic, String color) {
        this.bold = bold;
        this.italic = italic;
        this.color = color;
    }

    @Override
    public String toString() {
        return "(Bold: " + bold + ", Italic: " + italic + ", Color: " + color + ")";
    }
}

