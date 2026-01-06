package com.vocabularysrs.domain.worddetails;

public record WordHttpDto(
        String word,
        String phonetic,
        String audioUrl,
        WordHttpDetailsDto details
) {
}

