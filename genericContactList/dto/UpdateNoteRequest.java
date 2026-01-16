package genericContactList.dto;

import java.util.Map;
import java.util.Set;

public record UpdateNoteRequest(
        String userId,
        String title,
        String content,
        Set<String> tags,
        Map<String, String> contexts
) {}

