package com.vocabularysrs.infrastructure.dictionary.controller;

import lombok.Builder;

@Builder
public record WordDetailsControllerDto(
        String word,
        String phonetic,
        String audioUrl,
        String partOfSpeech,
        String definition,
        String example
) {
}
