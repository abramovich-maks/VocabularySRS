package com.vocabularysrs.domain.learningtaskgenerator;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

;

class InMemoryLearningTaskRepositoryTestImpl implements LearningTaskRepository {

    private final Map<Long, LearningTask> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public LearningTask save(final LearningTask task) {
        long index = this.index.getAndIncrement();
        database.put(task.getUserId(), task);
        task.setId(index);
        return task;
    }

    @Override
    public Optional<LearningTask> findLearningTaskByTaskDateAndUserId(final LocalDate taskDate, final Long userId) {
        return Optional.empty();
    }
}