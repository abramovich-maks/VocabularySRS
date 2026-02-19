package com.vocabularysrs.domain.learningtest;

import lombok.Getter;

@Getter
public class QuestionNotFoundException extends RuntimeException {

    private final Long questionId;
    private final Long userId;

    public QuestionNotFoundException(Long questionId, Long userId) {
        super("User " + userId + " does not have a question with id " + questionId + ".");
        this.questionId = questionId;
        this.userId = userId;
    }
}
