package com.vocabularysrs.domain.words.dto;

import lombok.Builder;

@Builder
public record WordWithAutoTranslateDtoRequest(
        String word,
        Long groupId
) {
}