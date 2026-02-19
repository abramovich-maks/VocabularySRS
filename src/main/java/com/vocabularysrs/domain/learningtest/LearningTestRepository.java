package com.vocabularysrs.domain.learningtest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.Optional;

interface LearningTestRepository extends Repository<LearningTest, Long> {
    LearningTest save(LearningTest task);

    @Query("""
                        select task
                        from LearningTest task
                        left join fetch task.questions
                        where task.userId = :userId
                        and task.taskDate = :taskDate
            """)
    Optional<LearningTest> findLearningTaskByTaskDateAndUserId(LocalDate taskDate, Long userId);

    @Query("""
                select task
                from LearningTest task
                join fetch task.questions q
                where q.id = :questionId
                and task.userId = :userId
            """)
    Optional<LearningTest> findByQuestionIdAndUserId(Long questionId, Long userId);
}

