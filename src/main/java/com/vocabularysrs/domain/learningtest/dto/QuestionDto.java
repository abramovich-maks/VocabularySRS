package com.vocabularysrs.domain.learningtest.dto;

import com.vocabularysrs.domain.learningtest.TranslationDirection;
import lombok.Builder;

@Builder
public record QuestionDto(
        Long id,
        Long wordEntryId,
        String prompt,
        TranslationDirection direction,
        boolean answered

) {
}