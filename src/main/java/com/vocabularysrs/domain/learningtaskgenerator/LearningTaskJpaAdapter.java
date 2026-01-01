package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Component
class LearningTaskJpaAdapter implements LearningTaskReadPort, LearningTaskWritePort {

    private final LearningTaskRepository learningTaskRepository;

    @Override
    public LearningTaskSnapshot findLearningTaskByDateAndUserId(final LocalDate taskDate, final Long userId) {
        LearningTask task = learningTaskRepository.findLearningTaskByTaskDateAndUserId(taskDate, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(taskDate, userId));
        List<QuestionSnapshot> questionList = task.getQuestions()
                .stream()
                .map(question -> new QuestionSnapshot(question.getId(), question.getWordEntryId(), question.getPrompt(), question.getDirection(), question.getAnswer()))
                .toList();
        return new LearningTaskSnapshot(task.getId(), task.getTaskDate(), task.getUserId(), questionList, task.getStatus());
    }

    @Override
    public boolean existsFor(Long userId, LocalDate date) {
        return learningTaskRepository.existsByUserIdAndTaskDate(userId, date);
    }

    @Override
    public void markCompleted(Long userId, LocalDate date) {
        LearningTask task = learningTaskRepository.findLearningTaskByTaskDateAndUserId(date, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(date, userId));
        task.markCompleted();
        learningTaskRepository.save(task);
    }
}
