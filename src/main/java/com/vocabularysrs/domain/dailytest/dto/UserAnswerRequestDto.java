package com.vocabularysrs.domain.dailytest.dto;

public record UserAnswerRequestDto(
        Long questionId,
        String answer
) {
}
