package com.vocabularysrs.infrastructure.dailytest;

import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;

import java.util.List;

public record DailyTestControllerResponseDto(
        Long userId,
        int total,
        int correct,
        int incorrect,
        List<AnswerResultDto> answers
) {
}

