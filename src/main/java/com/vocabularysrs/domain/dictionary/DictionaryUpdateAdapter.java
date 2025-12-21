package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dailytest.DictionaryUpdatePort;
import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
class DictionaryUpdateAdapter implements DictionaryUpdatePort {

    private final WordEntryRepository wordEntryRepository;
    private final WordRetriever wordRetriever;
    private final RepetitionIntervalCalculator calculator;

    private final AdjustableClock clock;

    @Override
    public void update(DailyTestResponseDto result) {
        LocalDate today = clock.today();
        Map<Long, List<AnswerResultDto>> answersByWord =
                result.answers().stream()
                        .collect(Collectors.groupingBy(AnswerResultDto::wordEntryId));
        for (Map.Entry<Long, List<AnswerResultDto>> entry : answersByWord.entrySet()) {
            Long wordId = entry.getKey();
            List<AnswerResultDto> answersForWord = entry.getValue();
            boolean correct = answersForWord.stream().allMatch(AnswerResultDto::correct);
            WordEntry entityById = wordRetriever.findEntityById(wordId);
            entityById.applyReviewResult(correct, calculator, today);
            wordEntryRepository.save(entityById);
        }
    }
}
