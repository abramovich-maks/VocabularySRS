package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskWritePort;

import java.time.LocalDate;

class LearningTaskWritePortTestImpl implements LearningTaskWritePort {

    boolean completed = false;
    Long completedUserId;
    LocalDate completedDate;

    @Override
    public void markCompleted(Long userId, LocalDate date) {
        this.completed = true;
        this.completedUserId = userId;
        this.completedDate = date;
    }
}
