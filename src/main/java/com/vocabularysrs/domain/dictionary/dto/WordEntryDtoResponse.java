package com.vocabularysrs.domain.dictionary.dto;

import lombok.Builder;

@Builder
public record WordEntryDtoResponse(
        String word,
        String translate,
        String message
) {
}
