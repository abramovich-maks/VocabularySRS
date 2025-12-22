package com.vocabularysrs.domain.dailytest.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record DailyTestShowResponseDto(
        Long id,
        LocalDate taskDate,
        Long userId,
        List<QuestionDto> questions
) {
}
