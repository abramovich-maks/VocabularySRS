package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Log4j2
class DailyTestResultRetriever {

    private final LearningTestRepository learningTestRepository;
    private final WordEntryUpdatePort wordEntryUpdatePort;
    private final CurrentUserProvider currentUserProvider;
    private final Clock clock;


    public DailyTestResponseDto resultTest() {
        LocalDate today = LocalDate.now(clock);
        Long userId = currentUserProvider.getCurrentUserId();

        LearningTest test = learningTestRepository.findLearningTaskByTaskDateAndUserId(today, userId)
                .orElseThrow(() -> new LearningTestNotFoundException(today, userId));

        List<AnswerResultDto> results = test.getQuestions().stream()
                .filter(Question::isAnswered)
                .map(Question::toResult)
                .toList();

        long correct = results.stream().filter(AnswerResultDto::correct).count();
        long incorrect = results.size() - correct;

        DailyTestResponseDto response = DailyTestResponseDto.builder()
                .userId(userId)
                .total(results.size())
                .correct((int) correct)
                .incorrect((int) incorrect)
                .answers(results)
                .build();

        log.info("DailyTest results size = {}", results.size());

        wordEntryUpdatePort.update(response);

        return response;
    }
}
