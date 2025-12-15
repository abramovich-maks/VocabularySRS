package com.vocabularysrs.domain.dictionary;

public record WordEntrySnapshot(
        Long id,
        Long userId,
        String word,
        String translate
) {
}