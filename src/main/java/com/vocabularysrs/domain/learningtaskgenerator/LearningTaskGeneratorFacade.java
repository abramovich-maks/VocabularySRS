package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class LearningTaskGeneratorFacade {

    private final LearningTaskAdder learningTaskAdder;

    public List<LearningTask> generateTasks(LocalDate date) {
        return learningTaskAdder.generateTasks(date);
    }

}