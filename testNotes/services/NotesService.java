package testNotes.services;

import testNotes.exceptions.NoteNotFoundException;
import testNotes.models.Note;
import testNotes.respositories.NotesRepositories;

import java.util.Optional;

public class NotesService {
    private final NotesRepositories notesRepositories;

    public NotesService() {
        this.notesRepositories = new NotesRepositories();
    }

    public Note create(Note note) {
        return notesRepositories.save(note);
    }

    public Note get(String id) throws NoteNotFoundException {
        return notesRepositories.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note with this id not exist"));
    }

    public Note delete(String id ) {
        return notesRepositories.deleteById(id)
                .orElseThrow(() -> new RuntimeException("Note with this id not exist"));
    }
}
