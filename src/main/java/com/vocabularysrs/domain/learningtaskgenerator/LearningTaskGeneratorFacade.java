package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LearningTaskGeneratorFacade {

    private final LearningTaskAdder learningTaskAdder;

    public List<LearningTask> generateTasks() {
        return learningTaskAdder.generateTasks();
    }

}