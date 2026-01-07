package com.vocabularysrs.domain.words;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum RepetitionInterval {
    INTERVAL_1_DAY(1),
    INTERVAL_3_DAYS(3),
    INTERVAL_5_DAYS(5),
    INTERVAL_10_DAYS(10),
    INTERVAL_15_DAYS(15),
    INTERVAL_25_DAYS(25);

    private final int days;
}
