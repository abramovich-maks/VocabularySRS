package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WordDetailsControllerDto(
        String phonetic,
        String audioUrl,
        String example,
        List<String> alternativeTranslate
) {
}
