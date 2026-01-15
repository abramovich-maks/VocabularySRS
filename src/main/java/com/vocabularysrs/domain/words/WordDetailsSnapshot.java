package com.vocabularysrs.domain.words;

public record WordDetailsSnapshot(
        String phonetic,
        String audioUrl,
        String definition,
        String example
) {
}

