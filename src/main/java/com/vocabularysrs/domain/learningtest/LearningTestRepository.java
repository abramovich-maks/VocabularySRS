package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.loginandregister.User;
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
                        where task.user = :user
                        and task.taskDate = :taskDate
            """)
    Optional<LearningTest> findLearningTaskByTaskDateAndUser(LocalDate taskDate, User user);

    @Query("""
                select task
                from LearningTest task
                join fetch task.questions q
                where q.id = :questionId
                and task.user = :user
            """)
    Optional<LearningTest> findByQuestionIdAndUser(Long questionId, User user);
}

