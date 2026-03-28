package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.loginandregister.User;

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
        storage.put(key(test.getTaskDate(), test.getUser().getId()), test);
        return test;
    }

    @Override
    public Optional<LearningTest> findLearningTaskByTaskDateAndUser(LocalDate date, User user) {
        return Optional.ofNullable(storage.get(key(date, user.getId())));
    }

    @Override
    public Optional<LearningTest> findByQuestionIdAndUser(Long questionId, User user) {
        return storage.values().stream()
                .filter(test -> test.getUser().getId().equals(user.getId()))
                .filter(test -> test.getQuestions().stream()
                        .anyMatch(q -> q.getId().equals(questionId)))
                .findFirst();
    }



    private String key(LocalDate date, Long userId) {
        return date + "_" + userId;
    }
}
