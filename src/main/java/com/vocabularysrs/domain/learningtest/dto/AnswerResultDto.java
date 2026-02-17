package com.vocabularysrs.domain.learningtest.dto;

import lombok.Builder;

@Builder
public record AnswerResultDto(
        Long questionId,
        Long wordEntryId,
        String word,
        String userAnswer,
        String correctAnswer,
        boolean correct
) {
}
