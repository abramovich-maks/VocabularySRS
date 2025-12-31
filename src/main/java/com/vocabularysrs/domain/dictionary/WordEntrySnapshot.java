package com.vocabularysrs.domain.dictionary;

import lombok.Builder;

@Builder
public record WordEntrySnapshot(
        Long id,
        Long userId,
        String word,
        String translate
) {
}