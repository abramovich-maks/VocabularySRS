package com.vocabularysrs.domain.learningtaskgenerator;

import java.time.LocalDate;

public interface LearningTaskWritePort {
    void markCompleted(Long userId, LocalDate date);
}