package com.vocabularysrs.domain.learningtest.dto;

import com.vocabularysrs.domain.learningtest.TranslationDirection;

public record QuestionSnapshot(
        Long id,
        Long wordEntryId,
        String prompt,
        TranslationDirection direction,
        boolean answered
) {
}
