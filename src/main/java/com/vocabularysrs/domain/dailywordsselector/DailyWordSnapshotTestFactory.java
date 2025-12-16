package com.vocabularysrs.domain.dailywordsselector;

import java.time.LocalDate;
import java.util.List;

public class DailyWordSnapshotTestFactory {

    public static DailyWordSnapshot withSingleWord(
            Long userId,
            String word,
            String translation
    ) {
        return new DailyWordSnapshot(
                1L,
                userId,
                LocalDate.now(),
                List.of(
                        new ReviewWordItemSnapshot(1L, word, translation)
                )
        );
    }
}