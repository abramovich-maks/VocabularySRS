package com.vocabularysrs.domain.learningtest;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LearningTestNotFoundException extends RuntimeException {

    private final LocalDate taskDate;
    private final Long userId;

    public LearningTestNotFoundException(LocalDate taskDate, Long userId) {
        super("User " + userId + " does not have a learning test for date " + taskDate + ".");
        this.taskDate = taskDate;
        this.userId = userId;
    }
}
