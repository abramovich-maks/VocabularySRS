package com.vocabularysrs.infrastructure.dictionary.controller;

import lombok.Builder;

import java.util.List;

@Builder
public record WordDetailsControllerDto(
        String phonetic,
        String audioUrl,
        String definition,
        String example,
        List<String> alternativeTranslate
) {
}
