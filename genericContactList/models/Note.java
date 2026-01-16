package genericContactList.models;

import java.time.LocalDateTime;
import java.util.*;

public class Note {

    private final String noteId;
    private final String userId;

    private String title;
    private String content;
    private NoteType type;
    private boolean archived;

    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private final Set<Tag> tags = new HashSet<>();
    private final Map<String, String> contexts = new HashMap<>();

    public Note(String noteId, String userId, String title, String content, NoteType type) {
        this.noteId = noteId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.type = type;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isArchived() {
        return archived;
    }

    public void archive() {
        this.archived = true;
    }

    public void update(String title, String content) {
        if (title != null) this.title = title;
        if (content != null) this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Map<String, String> getContexts() {
        return contexts;
    }

    public boolean matchesKeyword(String keyword) {
        return title.contains(keyword) || content.contains(keyword);
    }
}

