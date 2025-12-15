package com.vocabularysrs.domain.dailywordsselector;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryDailyWordRepositoryTestImpl implements DailyWordRepository {
    private final Map<Long, DailyWordReview> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    Collection<DailyWordReview> findAll() {
        return database.values();
    }

    @Override
    public DailyWordReview save(final DailyWordReview task) {
        long index = this.index.getAndIncrement();
        database.put(task.getUserId(), task);
        task.setId(index);
        return task;
    }
}