package com.vocabularysrs.domain.worddetails.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WordHttpDto(
        String word,
        String phonetic,
        String audioUrl,
        String partOfSpeech,
        String example,
        List<String> alternatives
) {
}

