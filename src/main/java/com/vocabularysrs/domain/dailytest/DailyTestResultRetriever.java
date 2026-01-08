package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskResultPort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Log4j2
class DailyTestResultRetriever {

    private final LearningTaskResultPort learningTaskResultPort;
    private final DictionaryUpdatePort dictionaryUpdatePort;
    private final CurrentUserProvider currentUserProvider;
    private final Clock clock;

    public DailyTestResponseDto resultTest() {
        LocalDate today = LocalDate.now(clock);
        Long userId = currentUserProvider.getCurrentUserId();

        List<AnswerResult> results = learningTaskResultPort.getResultsForTask(today, userId);

        long correct = results.stream().filter(AnswerResult::correct).count();
        long incorrect = results.size() - correct;

        DailyTestResponseDto response = DailyTestResponseDto.builder()
                .userId(userId)
                .total(results.size())
                .correct((int) correct)
                .incorrect((int) incorrect)
                .answers(results)
                .build();

        log.info("DailyTest results size = {}", results.size());

        dictionaryUpdatePort.update(response);

        return response;
    }
}
