package com.vocabularysrs.domain.learningtest.dto;

import com.vocabularysrs.domain.learningtest.DailyTestStatus;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record DailyTestDto(
        Long id,
        LocalDate taskDate,
        Long userId,
        List<QuestionDto> questions,
        DailyTestStatus status,
        LocalDate nextReviewDate
) {
}
