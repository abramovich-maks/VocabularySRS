package com.vocabularysrs.domain.dailywordsselector;

public record ReviewWordItemSnapshot(
        Long wordEntryId,
        String word,
        String translation
) {
}
