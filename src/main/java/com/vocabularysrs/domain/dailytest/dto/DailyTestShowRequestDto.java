package com.vocabularysrs.domain.dailytest.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DailyTestShowRequestDto(
        Long userId,
        LocalDate date
) {
}
