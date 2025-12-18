package com.vocabularysrs.domain.dailytest.dto;

import java.time.LocalDate;
import java.util.List;

public record DailyTestRequestDto(
        Long userId,
        LocalDate date,
        List<UserAnswerRequestDto> answers
) {
}
