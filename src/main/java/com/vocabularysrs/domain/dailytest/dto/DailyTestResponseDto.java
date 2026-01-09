package com.vocabularysrs.domain.dailytest.dto;

import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import lombok.Builder;

import java.util.List;

@Builder
public record DailyTestResponseDto(
        Long userId,
        int total,
        int correct,
        int incorrect,
        List<AnswerResult> answers
) {
}
