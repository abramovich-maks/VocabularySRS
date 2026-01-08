package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskWritePort;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;

import static com.vocabularysrs.domain.dailytest.DailyTestMapper.mapFromAnswerResultToAnswerResultDto;

@AllArgsConstructor
class DailyTestAnswerAccepter {

    private final LearningTaskWritePort learningTaskWritePort;
    private final CurrentUserProvider currentUserProvider;

    public AnswerResultDto answerQuestion(Long questionId, String userAnswer) {
        Long userId = currentUserProvider.getCurrentUserId();
        AnswerResult result = learningTaskWritePort.answerQuestion(userId, questionId, userAnswer);
        return mapFromAnswerResultToAnswerResultDto(result);

    }
}