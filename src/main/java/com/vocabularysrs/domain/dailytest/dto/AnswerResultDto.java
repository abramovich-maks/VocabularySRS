package com.vocabularysrs.domain.dailytest.dto;

import lombok.Builder;

@Builder
public record AnswerResultDto(
        Long questionId,
        Long wordEntryId,
        String userAnswer,
        String correctAnswer,
        boolean correct
) {
}
