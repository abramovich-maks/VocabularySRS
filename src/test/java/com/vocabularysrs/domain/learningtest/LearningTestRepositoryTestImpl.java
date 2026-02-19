package com.vocabularysrs.domain.learningtest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

class LearningTestRepositoryTestImpl implements LearningTestRepository {
    private final Map<String, LearningTest> storage = new HashMap<>();
    AtomicInteger questionId = new AtomicInteger(1);


    @Override
    public LearningTest save(final LearningTest test) {
        test.getQuestions().forEach(q -> {
            if (q.getId() == null) {
                long id = questionId.getAndIncrement();
                q.setId(id);
            }
        });
        storage.put(key(test.getTaskDate(), test.getUserId()), test);
        return test;
    }

    @Override
    public Optional<LearningTest> findLearningTaskByTaskDateAndUserId(LocalDate date, Long userId) {
        return Optional.ofNullable(storage.get(key(date, userId)));
    }

    @Override
    public Optional<LearningTest> findByQuestionIdAndUserId(Long questionId, Long userId) {
        return storage.values().stream()
                .filter(test -> test.getUserId().equals(userId))
                .filter(test -> test.getQuestions().stream()
                        .anyMatch(q -> q.getId().equals(questionId)))
                .findFirst();
    }



    private String key(LocalDate date, Long userId) {
        return date + "_" + userId;
    }
}
