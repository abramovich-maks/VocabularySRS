package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

@Builder
public record WordUpdatePartiallyDtoResponse(
        Long id,
        String word,
        String translate,
        String message
) {
}
