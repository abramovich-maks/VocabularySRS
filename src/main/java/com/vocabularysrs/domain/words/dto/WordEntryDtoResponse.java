package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordEntryDtoResponse(
        Long id,
        String word,
        String translate,
        String message
) {
}
