package com.vocabularysrs.infrastructure.dictionary;

import lombok.Builder;

@Builder
public record WordEntryControllerDtoResponse(
        String word,
        String translate,
        String message
) {
}
