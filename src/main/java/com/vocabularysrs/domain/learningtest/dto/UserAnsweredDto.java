package com.vocabularysrs.domain.learningtest.dto;

import lombok.Builder;

@Builder
public record UserAnsweredDto(
        Long questionId,
        Long wordEntryId,
        String userAnswer,
        String correctAnswer,
        boolean correct
) {
}
