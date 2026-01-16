package genericContactList.repositories;

import genericContactList.models.Note;

import java.util.*;

public class NoteRepository {

    private final Map<String, Note> notes = new HashMap<>();

    public void save(Note note) {
        notes.put(note.getNoteId(), note);
    }

    public Optional<Note> findById(String noteId) {
        return Optional.ofNullable(notes.get(noteId));
    }

    public List<Note> findAllByUser(String userId) {
        List<Note> result = new ArrayList<>();
        for (Note note : notes.values()) {
            if (note.getUserId().equals(userId) && !note.isArchived()) {
                result.add(note);
            }
        }
        return result;
    }
}

