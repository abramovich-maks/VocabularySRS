package com.vocabularysrs.domain.dailytest.dto;

import java.util.List;

public record DailyTestRequestDto(
        List<UserAnswerRequestDto> answers
) {
}
