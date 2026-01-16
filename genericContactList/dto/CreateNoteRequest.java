package genericContactList.dto;

import genericContactList.models.NoteType;
import java.util.Map;
import java.util.Set;

public record CreateNoteRequest(
        String userId,
        String title,
        String content,
        NoteType type,
        Set<String> tags,
        Map<String, String> contexts
) {}

