package com.vocabularysrs.domain.dictionary;

public record WordHttpDetailsDto(
        String partOfSpeech,
        String definition,
        String example
) {
}
