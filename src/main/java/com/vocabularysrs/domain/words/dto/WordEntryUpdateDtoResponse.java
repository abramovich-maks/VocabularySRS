package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordEntryUpdateDtoResponse(
        Long id,
        String word,
        String translate,
        String message
) {
}
