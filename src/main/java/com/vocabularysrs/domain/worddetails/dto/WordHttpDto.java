package com.vocabularysrs.domain.worddetails.dto;

import com.vocabularysrs.domain.globalwords.dto.WordExampleResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record WordHttpDto(
        String word,
        String phonetic,
        String audioUrl,
        String partOfSpeech,
        List<WordExampleResponse> examples,
        List<String> alternatives
) {
}

