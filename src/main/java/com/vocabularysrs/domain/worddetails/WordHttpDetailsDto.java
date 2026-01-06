package com.vocabularysrs.domain.worddetails;

public record WordHttpDetailsDto(
        String partOfSpeech,
        String definition,
        String example
) {
}
