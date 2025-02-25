package googleDocs.src.services;

import googleDocs.src.models.Document;
import googleDocs.src.models.DocumentElement;
import googleDocs.src.models.Style;

public class DocumentService {
    private Document document;

    public DocumentService(Document document) {
        this.document = document;
    }

    public void addHeader(String text, String color) {
        document.addElement(new DocumentElement("Header", text, new Style(true, false, color)));
    }

    public void addParagraph(String text) {
        document.addElement(new DocumentElement("Paragraph", text, new Style(false, false, "black")));
    }

    public void displayDocument() {
        document.display();
    }

    public void showRevisions() {
        System.out.println("\n📜 Revision History:");
        document.getRevisions().forEach(System.out::println);
    }
}

