package com.vocabularysrs.domain.learningtaskgenerator;

import java.time.LocalDate;
import java.util.List;

public record LearningTaskDto(
        Long id,
        LocalDate taskDate,
        Long userId,
        List<QuestionSnapshot> questions,
        LearningTaskStatus status
) {
}
