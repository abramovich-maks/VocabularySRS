package com.vocabularysrs.domain.dictionary;

public record WordHttpDto(
        String word,
        String phonetic,
        String audioUrl,
        WordHttpDetailsDto details
) {
}

