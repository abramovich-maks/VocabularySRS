package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskWritePort;

class LearningTaskWritePortTestImpl implements LearningTaskWritePort {

    @Override
    public AnswerResult answerQuestion(
            final Long userId,
            final Long questionId,
            final String userAnswer
    ) {
        return AnswerResult.builder()
                .questionId(questionId)
                .wordEntryId(1L)
                .userAnswer(userAnswer)
                .correctAnswer("cat")
                .correct(true)
                .build();
    }
}
