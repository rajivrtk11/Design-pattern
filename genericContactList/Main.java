package genericContactList;

import genericContactList.dto.*;
import genericContactList.models.NoteType;
import genericContactList.services.NoteService;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        NoteService service = new NoteService();

        // Doctor note
        service.createNote(new CreateNoteRequest(
                "U1",
                "Patient medication",
                "Metformin 500mg daily",
                NoteType.TEXT,
                Set.of("diabetes"),
                Map.of("patient", "Amit", "diagnosis", "Type2")
        ));

        // Student note
        service.createNote(new CreateNoteRequest(
                "U1",
                "Physics class",
                "Newton's laws",
                NoteType.TEXT,
                Set.of("physics"),
                Map.of("subject", "Physics", "semester", "4")
        ));

        // Search
        var results = service.searchNotes(new NoteSearchCriteria(
                "U1",
                null,
                Set.of("diabetes"),
                Map.of("patient", "Amit")
        ));

        System.out.println("Found notes: " + results.size());
    }
}

