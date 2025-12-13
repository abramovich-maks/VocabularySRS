package com.vocabularysrs.domain.taskcreator;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryReviewTaskRepositoryTestImpl implements ReviewTaskRepository {

    private final Map<LocalDate, ReviewTask> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public Optional<ReviewTask> findByTaskDate(final LocalDate taskDate) {
        return Optional.ofNullable(database.get(taskDate));
    }

    @Override
    public ReviewTask save(final ReviewTask task) {
        long index = this.index.getAndIncrement();
        database.put(task.getTaskDate(), task);
        task.setId(index);
        return task;
    }
}