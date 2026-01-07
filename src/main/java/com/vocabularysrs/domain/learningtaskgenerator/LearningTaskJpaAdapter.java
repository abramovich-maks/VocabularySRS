package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Component
class LearningTaskJpaAdapter implements LearningTaskReadPort, LearningTaskWritePort {

    private final LearningTaskRepository learningTaskRepository;

    @Override
    public LearningTaskDto findLearningTaskByDateAndUserId(final LocalDate taskDate, final Long userId) {
        LearningTask task = learningTaskRepository.findLearningTaskByTaskDateAndUserId(taskDate, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(taskDate, userId));
        return LearningTaskMapper.mapFromLearningTaskToLearningTaskDto(task);
    }

    @Override
    public Optional<LearningTaskDto> findInProgress(LocalDate date, Long userId) {
        return learningTaskRepository.findLearningTaskByTaskDateAndUserId(date, userId)
                .map(LearningTaskMapper::mapFromLearningTaskToLearningTaskDto);
    }

    @Override
    public void markCompleted(Long userId, LocalDate date) {
        LearningTask task = learningTaskRepository.findLearningTaskByTaskDateAndUserId(date, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(date, userId));
        task.markCompleted();
        learningTaskRepository.save(task);
    }
}
