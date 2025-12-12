package com.vocabularysrs.infrastructure.dictionary.dto;

import lombok.Builder;

@Builder
public record WordUpdatePartiallyDtoResponse(
        Long id,
        String word,
        String translate,
        String message
) {
}
