package com.vocabularysrs.infrastructure.dailytest;

import jakarta.validation.constraints.NotEmpty;

public record AnswerQuestionRequestDto(
        @NotEmpty
        String userAnswer
) {
}