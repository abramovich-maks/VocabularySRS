package com.vocabularysrs.domain.learningtaskgenerator;

public interface LearningTaskWritePort {
    AnswerResult answerQuestion(Long userId, Long questionId, String userAnswer);
}