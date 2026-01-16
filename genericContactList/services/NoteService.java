package genericContactList.services;


import genericContactList.dto.CreateNoteRequest;
import genericContactList.dto.NoteSearchCriteria;
import genericContactList.dto.UpdateNoteRequest;
import genericContactList.models.*;
import genericContactList.repositories.NoteRepository;

import java.util.*;
import java.util.stream.Collectors;

public class NoteService {

    private final NoteRepository repository = new NoteRepository();

    public Note createNote(CreateNoteRequest request) {

        Note note = new Note(
                UUID.randomUUID().toString(),
                request.userId(),
                request.title(),
                request.content(),
                request.type()
        );

        request.tags().forEach(t -> note.getTags().add(new Tag(t)));
        request.contexts().forEach((k, v) -> note.getContexts().put(k.toLowerCase(), v));

        repository.save(note);
        return note;
    }

    public void updateNote(String noteId, UpdateNoteRequest request) {

        Note note = repository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        if (!note.getUserId().equals(request.userId())) {
            throw new RuntimeException("Unauthorized");
        }

        note.update(request.title(), request.content());

        if (request.tags() != null) {
            note.getTags().clear();
            request.tags().forEach(t -> note.getTags().add(new Tag(t)));
        }

        if (request.contexts() != null) {
            note.getContexts().clear();
            request.contexts().forEach((k, v) -> note.getContexts().put(k, v));
        }
    }

    public void deleteNote(String noteId, String userId) {
        Note note = repository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        if (!note.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized");
        }

        note.archive();
    }

    public List<Note> searchNotes(NoteSearchCriteria criteria) {

        return repository.findAllByUser(criteria.userId()).stream()
                .filter(n -> criteria.keyword() == null || n.matchesKeyword(criteria.keyword()))
                .filter(n -> criteria.tags() == null || n.getTags().containsAll(
                        criteria.tags().stream().map(Tag::new).collect(Collectors.toSet())
                ))
                .filter(n -> criteria.contexts() == null || criteria.contexts().entrySet().stream()
                        .allMatch(e -> e.getValue().equals(n.getContexts().get(e.getKey()))))
                .toList();
    }
}

