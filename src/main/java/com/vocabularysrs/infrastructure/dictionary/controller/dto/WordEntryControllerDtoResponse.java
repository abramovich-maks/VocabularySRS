package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record WordEntryControllerDtoResponse(
        String word,
        String translate,
        String message
) {
}
