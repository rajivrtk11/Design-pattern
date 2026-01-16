package genericContactList.dto;

import java.util.Map;
import java.util.Set;

public record NoteSearchCriteria(
        String userId,
        String keyword,
        Set<String> tags,
        Map<String, String> contexts
) {}
