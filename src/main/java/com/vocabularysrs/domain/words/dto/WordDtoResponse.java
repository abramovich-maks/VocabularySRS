package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordDtoResponse(
        Long id,
        String word,
        String translate
) {
}