package com.vocabularysrs.domain.dictionary;

import org.springframework.stereotype.Component;

import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_10_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_15_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_1_DAY;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_25_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_3_DAYS;
import static com.vocabularysrs.domain.dictionary.RepetitionInterval.INTERVAL_5_DAYS;

@Component
class RepetitionIntervalCalculator {

    RepetitionInterval next(RepetitionInterval current) {
        return switch (current) {
            case INTERVAL_1_DAY -> INTERVAL_3_DAYS;
            case INTERVAL_3_DAYS -> INTERVAL_5_DAYS;
            case INTERVAL_5_DAYS -> INTERVAL_10_DAYS;
            case INTERVAL_10_DAYS -> INTERVAL_15_DAYS;
            case INTERVAL_15_DAYS, INTERVAL_25_DAYS -> INTERVAL_25_DAYS;
        };
    }

    RepetitionInterval back(RepetitionInterval current) {
        return switch (current) {
            case INTERVAL_25_DAYS -> INTERVAL_15_DAYS;
            case INTERVAL_15_DAYS -> INTERVAL_10_DAYS;
            case INTERVAL_10_DAYS -> INTERVAL_5_DAYS;
            case INTERVAL_5_DAYS -> INTERVAL_3_DAYS;
            case INTERVAL_3_DAYS, INTERVAL_1_DAY -> INTERVAL_1_DAY;
        };
    }
}
