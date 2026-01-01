package com.vocabularysrs.domain.dailytest;

import java.time.LocalDate;

public class DailyTestAlreadyCompletedException extends RuntimeException {

    public final LocalDate taskDate;

    public DailyTestAlreadyCompletedException(final LocalDate taskDate) {
        super("Daily test for " + taskDate + " is already completed. Please come back tomorrow.");
        this.taskDate = taskDate;
    }
}