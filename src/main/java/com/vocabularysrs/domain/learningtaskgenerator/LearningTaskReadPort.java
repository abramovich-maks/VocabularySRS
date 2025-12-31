package com.vocabularysrs.domain.learningtaskgenerator;

import java.time.LocalDate;

public interface LearningTaskReadPort {
    LearningTaskSnapshot findLearningTaskByDateAndUserId(LocalDate today, Long userId);

    boolean existsFor(Long userId, LocalDate date);

}
