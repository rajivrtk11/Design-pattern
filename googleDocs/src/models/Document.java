package googleDocs.src.models;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private int docId;
    private String title;
    private List<DocumentElement> elements;
    private List<Revision> revisions;
    private List<?> list;

    public Document(int docId, String title) {
        this.docId = docId;
        this.title = title;
        this.elements = new ArrayList<>();
        this.revisions = new ArrayList<>();
    }

    public void addElement(DocumentElement element) {
        elements.add(element);
        revisions.add(new Revision("Added element: " + element.getContent()));
    }

    public void display() {
        System.out.println("📄 Document: " + title);
        for (DocumentElement element : elements) {
            element.display();
        }
    }

    public List<Revision> getRevisions() {
        return revisions;
    }
}

