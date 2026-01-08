package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskDto;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;

@AllArgsConstructor
class DailyTestRetriever {

    private final LearningTaskReadPort learningTaskReadPort;
    private final LearningTaskGeneratorFacade learningTaskGeneratorFacade;
    private final CurrentUserProvider currentUserProvider;

    private final Clock clock;


    public DailyTestShowResponseDto retrieveDailyTest() {
        LocalDate today = LocalDate.now(clock);
        Long userId = currentUserProvider.getCurrentUserId();

        LearningTaskDto task = learningTaskReadPort.findInProgress(today, userId)
                .orElseGet(() -> learningTaskGeneratorFacade.generateForUser(today, userId));

        var unansweredQuestions = task.questions().stream()
                .filter(q -> !q.answered())
                .toList();

        if (unansweredQuestions.isEmpty()) {
            throw new DailyTestAlreadyCompletedException(today);
        }
        return DailyTestShowResponseDto.builder()
                .id(task.id())
                .userId(task.userId())
                .taskDate(task.taskDate())
                .questions(
                        unansweredQuestions.stream()
                                .map(DailyTestMapper::mapFromQuestionSnapshotToQuestionDto)
                                .toList()
                ).build();
    }
}
