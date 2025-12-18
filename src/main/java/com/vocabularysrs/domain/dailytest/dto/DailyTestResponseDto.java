package com.vocabularysrs.domain.dailytest.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record DailyTestResponseDto(
        Long userId,
        int total,
        int correct,
        int incorrect,
        List<AnswerResultDto> answers
) {
}
