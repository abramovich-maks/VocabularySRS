package com.vocabularysrs.infrastructure.dailytest;

import com.vocabularysrs.domain.dailytest.dto.UserAnswerRequestDto;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record DailyTestControllerRequestDto(
        @NotEmpty
        List<UserAnswerRequestDto> answers
) {
}