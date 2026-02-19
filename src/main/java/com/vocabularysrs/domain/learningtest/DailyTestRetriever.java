package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.DailyTestDto;
import com.vocabularysrs.domain.learningtest.dto.LearningTestDto;
import com.vocabularysrs.domain.learningtest.dto.QuestionDto;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
class DailyTestRetriever {

    private final LearningTestGenerator learningTestGenerator;
    private final CurrentUserProvider currentUserProvider;
    private final WordEntryReadPort wordEntryReadPort;
    private final LearningTestRepository learningTestRepository;

    private final Clock clock;


    public DailyTestDto retrieveDailyTest() {
        LocalDate today = LocalDate.now(clock);
        Long userId = currentUserProvider.getCurrentUserId();

        LearningTestDto test = findInProgress(today, userId)
                .orElseGet(() -> learningTestGenerator.generateDailyTest(today, userId));

        List<QuestionDto> questions = test.questions().stream()
                .filter(q -> !q.answered())
                .toList();

        if (questions.isEmpty()) {

            Optional<LocalDate> nearestReviewDate = wordEntryReadPort.findNearestReviewDate(userId);

            if (nearestReviewDate.isEmpty()) {
                return DailyTestDto.builder()
                        .status(DailyTestStatus.NO_WORDS)
                        .build();
            }

            return DailyTestDto.builder()
                    .status(DailyTestStatus.COMPLETED)
                    .nextReviewDate(nearestReviewDate.get())
                    .build();
        }
        return DailyTestDto.builder()
                .id(test.id())
                .userId(test.userId())
                .taskDate(test.taskDate())
                .questions(questions)
                .status(DailyTestStatus.AVAILABLE)
                .build();
    }

    public Optional<LearningTestDto> findInProgress(LocalDate date, Long userId) {
        return learningTestRepository.findLearningTaskByTaskDateAndUserId(date, userId)
                .map(LearningTestMapper::mapFromLearningTaskToLearningTaskDto);
    }
}
