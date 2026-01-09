package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.dailytest.DictionaryUpdatePort;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
class DictionaryUpdateAdapter implements DictionaryUpdatePort {

    private final WordEntryRepository wordEntryRepository;
    private final WordRetriever wordRetriever;
    private final RepetitionIntervalCalculator calculator;

    private final Clock clock;

    @Override
    public void update(DailyTestResponseDto result) {
        LocalDate today = LocalDate.now(clock);
        Map<Long, List<AnswerResult>> answersByWord =
                result.answers().stream()
                        .collect(Collectors.groupingBy(AnswerResult::wordEntryId));
        for (Map.Entry<Long, List<AnswerResult>> entry : answersByWord.entrySet()) {
            Long wordId = entry.getKey();
            List<AnswerResult> answersForWord = entry.getValue();
            boolean correct = answersForWord.stream().allMatch(AnswerResult::correct);
            WordEntry entityById = wordRetriever.findEntityById(wordId);
            entityById.applyReviewResult(correct, calculator, today);
            wordEntryRepository.save(entityById);
        }
    }
}
