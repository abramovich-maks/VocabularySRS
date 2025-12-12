package com.vocabularysrs.domain.dictionary.dto;

import lombok.Builder;

@Builder
public record WordEntryUpdateDtoResponse(
        Long id,
        String word,
        String translate,
        String message
) {
}
