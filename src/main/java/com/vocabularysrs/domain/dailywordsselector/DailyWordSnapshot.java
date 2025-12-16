package com.vocabularysrs.domain.dailywordsselector;

import java.time.LocalDate;
import java.util.List;

public record DailyWordSnapshot(
        Long id,
        Long userId,
        LocalDate taskDate,
        List<ReviewWordItemSnapshot> items
) {
}

