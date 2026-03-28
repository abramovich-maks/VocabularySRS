package com.vocabularysrs.domain.learningtest;

import org.springframework.data.repository.Repository;

interface LearningTestHistoryRepository extends Repository<LearningTestHistory, Long> {
    LearningTestHistory save(LearningTestHistory testHistory);
}