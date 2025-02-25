package googleDocs.src.models;

public class DocumentElement {
    private String content;
    private String type;  // "Header", "Paragraph", etc.
    private Style style;

    public DocumentElement(String type, String content, Style style) {
        this.type = type;
        this.content = content;
        this.style = style;
    }

    public String getContent() {
        return content;
    }

    public void applyStyle(Style newStyle) {
        this.style = newStyle;
    }

    public void display() {
        System.out.println("[" + type + "] " + content + " " + style);
    }
}

