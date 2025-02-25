package googleDocs.src;

import googleDocs.src.models.Document;
import googleDocs.src.services.DocumentService;

public class Main {
    public static void main(String[] args) {
        Document doc = new Document(1, "My First Doc");
        DocumentService docService = new DocumentService(doc);

        // Add content
        docService.addHeader("Introduction", "red");
        docService.addParagraph("This is the first paragraph.");
        docService.addParagraph("Google Docs allows rich text editing.");

        // Display document
        docService.displayDocument();

        // View revisions
        docService.showRevisions();
    }
}

