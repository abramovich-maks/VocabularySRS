package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.loginandregister.User;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Log4j2
class DailyTestResultRetriever {

    private final LearningTestRepository learningTestRepository;
    private final WordEntryUpdatePort wordEntryUpdatePort;
    private final CurrentUserProvider currentUserProvider;
    private final UserReadPort userReadPort;
    private final Clock clock;
    private final LearningTestHistoryRepository historyRepository;


    public DailyTestResponseDto resultTest() {
        LocalDate today = LocalDate.now(clock);
        Long userId = currentUserProvider.getCurrentUserId();
        User user = userReadPort.getReferenceById(userId);

        LearningTest test = learningTestRepository.findLearningTaskByTaskDateAndUser(today, user)
                .orElseThrow(() -> new LearningTestNotFoundException(today, userId));

        List<AnswerResult> results = getResults(test);
        DailyTestResponseDto response = buildResponse(results, userId);
        wordEntryUpdatePort.update(response);
        saveHistory(results, user, today);
        return response;
    }

    private static List<AnswerResult> getResults(final LearningTest test) {
        return test.getQuestions().stream()
                .filter(Question::isAnswered)
                .map(Question::toResult)
                .toList();
    }

    private DailyTestResponseDto buildResponse(List<AnswerResult> results, Long userId) {
        long correct = results.stream().filter(AnswerResult::correct).count();
        return DailyTestResponseDto.builder()
                .userId(userId)
                .total(results.size())
                .correct((int) correct)
                .incorrect(results.size() - (int) correct)
                .answers(results.stream()
                        .map(LearningTestMapper::mapFromAnswerResultToAnswerResultDto)
                        .toList())
                .build();
    }

    private void saveHistory(List<AnswerResult> results, User user, LocalDate today) {
        long correct = results.stream().filter(AnswerResult::correct).count();
        LearningTestHistory history = LearningTestHistory.builder()
                .user(user)
                .date(today)
                .totalQuestions(results.size())
                .correctAnswers((int) correct)
                .incorrectAnswers(results.size() - (int) correct)
                .answers(new ArrayList<>())
                .build();

        for (AnswerResult result : results) {
            AnswerResultEntity entity = AnswerResultEntity.builder()
                    .questionId(result.questionId())
                    .wordEntryId(result.wordEntryId())
                    .word(result.word())
                    .userAnswer(result.userAnswer())
                    .correctAnswer(result.correctAnswer())
                    .correct(result.correct())
                    .build();

            history.addAnswer(entity);
        }

        historyRepository.save(history);
    }
}
