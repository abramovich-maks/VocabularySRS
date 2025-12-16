package com.vocabularysrs.domain.learningtaskgenerator;

import java.util.Map;
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
}