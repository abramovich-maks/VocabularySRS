package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dailytest.DictionaryUpdatePort;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
class DictionaryUpdateAdapter implements DictionaryUpdatePort {

    private final WordEntryRepository wordEntryRepository;
    private final WordRetriever wordRetriever;
    private final RepetitionIntervalCalculator calculator;

    private final AdjustableClock clock;

    @Override
    public void update(DailyTestResponseDto result) {
        LocalDate today = clock.today();
        result.answers().forEach(answer -> {
            WordEntry entityById = wordRetriever.findEntityById(answer.wordEntryId());

            entityById.applyReviewResult(answer.correct(), calculator, today);
            wordEntryRepository.save(entityById);
        });
    }
}
