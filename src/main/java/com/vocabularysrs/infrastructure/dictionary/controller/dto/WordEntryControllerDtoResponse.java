package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record WordEntryControllerDtoResponse(
        Long id,
        String word,
        String translate,
        String message
) {
}
