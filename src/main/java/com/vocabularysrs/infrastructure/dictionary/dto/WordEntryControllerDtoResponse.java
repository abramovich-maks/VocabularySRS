package com.vocabularysrs.infrastructure.dictionary.dto;

import lombok.Builder;

@Builder
public record WordEntryControllerDtoResponse(
        String word,
        String translate,
        String message
) {
}
