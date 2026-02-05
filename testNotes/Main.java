package testNotes;

import testNotes.exceptions.NoteNotFoundException;
import testNotes.models.Note;
import testNotes.services.NotesService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) throws NoteNotFoundException {
        NotesService notesService = new NotesService();
        String uuid = UUID.randomUUID().toString();

        notesService.create(new Note(
                uuid,
                "First Note",
                "This is the note that i'm making"
        ));

        try {
            Note note = notesService.get("121");
            System.out.println("Notes: "+ note);
        }
        catch (Exception err) {
            System.out.println("message: "+ err);
        }
    }
}
