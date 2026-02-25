package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import com.vocabularysrs.domain.globalwords.dto.WordExampleResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record WordDetailsControllerDto(
        String phonetic,
        String audioUrl,
        List<WordExampleResponse> examples,
        List<String> alternativeTranslate
) {
}
