package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskSnapshot;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskStatus;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskWritePort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;

@AllArgsConstructor
public class DailyTestFacade {

    private final DailyTestChecker dailyTestChecker;
    private final CurrentUserProvider currentUserProvider;
    private final DictionaryUpdatePort dictionaryUpdatePort;
    private final DailyTestRetriever dailyTestRetriever;
    private final LearningTaskGeneratorFacade learningTaskGeneratorFacade;
    private final LearningTaskReadPort learningTaskReadPort;
    private final LearningTaskWritePort learningTaskWritePort;

    private final Clock clock;


    public DailyTestResponseDto processDailyTest(DailyTestRequestDto request) {
        Long userId = currentUserProvider.getCurrentUserId();
        LocalDate today = LocalDate.now(clock);
        DailyTestResponseDto response = dailyTestChecker.checkResult(buildShowRequest(userId, today), request.answers());
        learningTaskWritePort.markCompleted(userId, today);
        dictionaryUpdatePort.update(response);
        return response;
    }

    public DailyTestShowResponseDto retrieveDailyTest() {
        LocalDate today = LocalDate.now(clock);
        Long userId = currentUserProvider.getCurrentUserId();
        if (!learningTaskReadPort.existsFor(userId, today)) {
            learningTaskGeneratorFacade.generateTasks(today);
        }

        LearningTaskSnapshot task = learningTaskReadPort.findLearningTaskByDateAndUserId(today, userId);

        if (task.status() == LearningTaskStatus.COMPLETED) {
            throw new DailyTestAlreadyCompletedException(today);
        }
        return dailyTestRetriever.retrieveDailyTest(buildShowRequest(userId, today));
    }

    private static DailyTestShowRequestDto buildShowRequest(final Long userId, final LocalDate today) {
        return DailyTestShowRequestDto.builder()
                .userId(userId)
                .date(today)
                .build();
    }
}