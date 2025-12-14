package com.vocabularysrs.domain.dictionary;

public record WordEntrySnapshot(
        Long id,
        String word,
        String translate
) {
}