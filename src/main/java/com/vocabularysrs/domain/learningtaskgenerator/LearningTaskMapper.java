package com.vocabularysrs.domain.learningtaskgenerator;

import java.util.List;

class LearningTaskMapper {

    public static LearningTaskDto mapFromLearningTaskToLearningTaskDto(LearningTask task) {
        List<QuestionSnapshot> questions = task.getQuestions().stream()
                .map(q -> new QuestionSnapshot(
                        q.getId(),
                        q.getWordEntryId(),
                        q.getPrompt(),
                        q.getDirection(),
                        q.isAnswered()
                ))
                .toList();

        return new LearningTaskDto(
                task.getId(),
                task.getTaskDate(),
                task.getUserId(),
                questions,
                task.hasUnansweredQuestions()
        );
    }
}
