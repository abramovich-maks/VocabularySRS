package com.vocabularysrs.domain.learningtaskgenerator;

import java.time.LocalDate;

public class LearningTaskNotFoundException extends RuntimeException {
    public final LocalDate taskDate;
    public final Long userId;

    public LearningTaskNotFoundException(final LocalDate taskDate, final Long userId) {
        super("Task for user ID " + userId + " on " + taskDate + " was not found.");
        this.taskDate = taskDate;
        this.userId = userId;
    }
}
