package com.vocabularysrs.infrastructure.dictionary.dto;

import lombok.Builder;

@Builder
public record WordDtoControllerResponse(
        Long id,
        String word,
        String translate
) {
}