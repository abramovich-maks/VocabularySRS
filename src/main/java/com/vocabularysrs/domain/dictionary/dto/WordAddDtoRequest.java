package com.vocabularysrs.domain.dictionary.dto;

import lombok.Builder;

@Builder
public record WordAddDtoRequest(
        String word,
        String translate
) {
}
