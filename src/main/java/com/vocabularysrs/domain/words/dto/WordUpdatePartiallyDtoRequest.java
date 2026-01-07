package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordUpdatePartiallyDtoRequest(
        String word,
        String translate
) {
}
