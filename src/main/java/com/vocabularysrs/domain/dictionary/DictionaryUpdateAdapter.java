package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.dailytest.DictionaryUpdatePort;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class DictionaryUpdateAdapter implements DictionaryUpdatePort {

    private final WordEntryRepository wordEntryRepository;
    private final WordRetriever wordRetriever;
    private final RepetitionIntervalCalculator calculator;

    @Override
    public void update(DailyTestResponseDto result) {
        result.answers().forEach(answer -> {
            WordEntry entityById = wordRetriever.findEntityById(answer.wordEntryId());

            entityById.applyReviewResult(answer.correct(), calculator);
            wordEntryRepository.save(entityById);
        });
    }
}
