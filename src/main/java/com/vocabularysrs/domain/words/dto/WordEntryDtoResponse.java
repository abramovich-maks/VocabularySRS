package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordEntryDtoResponse(
        String word,
        String translate,
        String message
) {
}
