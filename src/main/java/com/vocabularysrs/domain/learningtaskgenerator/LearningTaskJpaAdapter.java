package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
class LearningTaskJpaAdapter implements LearningTaskReadPort {

    private final LearningTaskRepository learningTaskRepository;

    @Override
    public LearningTaskSnapshot findLearningTaskByDateAndUserId(final LocalDate taskDate, final Long userId) {
        LearningTask task = learningTaskRepository.findLearningTaskByTaskDateAndUserId(taskDate, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(taskDate, userId));
        List<QuestionSnapshot> questionList = task.getQuestions()
                .stream()
                .map(question -> new QuestionSnapshot(question.getId(), question.getPrompt(), question.getDirection(), question.getAnswer()))
                .toList();
        return new LearningTaskSnapshot(task.getId(), task.getTaskDate(), task.getUserId(), questionList);
    }
}
