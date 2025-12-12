package com.vocabularysrs.domain.dictionary.dto;

import lombok.Builder;

@Builder
public record WordDtoResponse(
        Long id,
        String word,
        String translate
) {
}