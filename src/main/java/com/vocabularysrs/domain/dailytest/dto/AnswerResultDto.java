package com.vocabularysrs.domain.dailytest.dto;

import lombok.Builder;

@Builder
public record AnswerResultDto(
        Long questionId,
        String userAnswer,
        String correctAnswer,
        boolean correct
) {
}
