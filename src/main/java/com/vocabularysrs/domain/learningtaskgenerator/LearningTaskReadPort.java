package com.vocabularysrs.domain.learningtaskgenerator;

import java.time.LocalDate;
import java.util.Optional;

public interface LearningTaskReadPort {
    LearningTaskDto findLearningTaskByDateAndUserId(LocalDate today, Long userId);

    Optional<LearningTaskDto> findInProgress(
            LocalDate date,
            Long userId
    );

}
