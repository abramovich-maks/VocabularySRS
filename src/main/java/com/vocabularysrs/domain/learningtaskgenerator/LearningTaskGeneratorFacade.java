package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

import static com.vocabularysrs.domain.learningtaskgenerator.LearningTaskMapper.mapFromLearningTaskToLearningTaskDto;

@AllArgsConstructor
public class LearningTaskGeneratorFacade {

    private final LearningTaskAdder learningTaskAdder;

    public LearningTaskDto generateForUser(LocalDate date, Long userId) {
        LearningTask task = learningTaskAdder.generateForUser(date, userId);
        return mapFromLearningTaskToLearningTaskDto(task);
    }

}