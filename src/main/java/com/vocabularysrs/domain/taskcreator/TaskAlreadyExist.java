package com.vocabularysrs.domain.taskcreator;

import java.time.LocalDate;

public class TaskAlreadyExist extends RuntimeException {

    private final LocalDate date;

    public TaskAlreadyExist(LocalDate date) {
        super("Task at " + date+" already exist!");
        this.date = date;
    }
}
