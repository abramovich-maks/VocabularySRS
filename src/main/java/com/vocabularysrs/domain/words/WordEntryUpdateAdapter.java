package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.learningtest.WordEntryUpdatePort;
import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Log4j2
class WordEntryUpdateAdapter implements WordEntryUpdatePort {

    private final WordEntryRepository wordEntryRepository;
    private final WordRetriever wordRetriever;
    private final RepetitionIntervalCalculator calculator;

    private final Clock clock;

    @Override
    public void update(DailyTestResponseDto result) {
        LocalDate today = LocalDate.now(clock);
        Map<Long, List<AnswerResultDto>> answersByWord =
                result.answers().stream()
                        .collect(Collectors.groupingBy(AnswerResultDto::wordEntryId));
        for (Map.Entry<Long, List<AnswerResultDto>> entry : answersByWord.entrySet()) {
            Long wordId = entry.getKey();
            List<AnswerResultDto> answersForWord = entry.getValue();
            boolean correct = answersForWord.stream().allMatch(AnswerResultDto::correct);
            try {
                WordEntry entityById = wordRetriever.findEntityById(wordId);
                entityById.applyReviewResult(correct, calculator, today);
                wordEntryRepository.save(entityById);
            } catch (WordNotFoundException e) {
                log.warn("Skipping dictionary update for missing wordEntryId={}", wordId);
            }
        }
    }
}
