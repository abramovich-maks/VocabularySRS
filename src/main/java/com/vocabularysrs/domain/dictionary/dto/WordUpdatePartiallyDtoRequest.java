package com.vocabularysrs.domain.dictionary.dto;

import lombok.Builder;

@Builder
public record WordUpdatePartiallyDtoRequest(
        String word,
        String translate
) {
}
