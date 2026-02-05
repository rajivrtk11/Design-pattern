package testNotes.respositories;

import testNotes.models.Note;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NotesRepositories {
    private Map<String, Note> notesDb;

    public NotesRepositories() {
        this.notesDb = new HashMap<>();
    }

    public Note save(Note note) {
        notesDb.put(note.getId(), note);
        return note;
    }

    public Optional<Note> findById(String id) {
        return Optional.ofNullable(notesDb.get(id));
    }

    public Optional<Note> deleteById(String id) {
        Note note = notesDb.get(id);
        Note deleted = notesDb.remove(id);
        return Optional.ofNullable(deleted);
    }
}
