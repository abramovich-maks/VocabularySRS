package com.vocabularysrs.domain.worddetails;

import lombok.Builder;

@Builder
public record WordHttpDto(
        String word,
        String phonetic,
        String audioUrl,
        String partOfSpeech,
        String definition,
        String example
) {
}

