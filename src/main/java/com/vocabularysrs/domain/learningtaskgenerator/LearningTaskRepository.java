package com.vocabularysrs.domain.learningtaskgenerator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.Optional;

interface LearningTaskRepository extends Repository<LearningTask, Long> {
    LearningTask save(LearningTask task);

    @Query("""
                        select task
                        from LearningTask task
                        left join fetch task.questions
                        where task.userId = :userId
                        and task.taskDate = :taskDate
            """)
    Optional<LearningTask> findLearningTaskByTaskDateAndUserId(LocalDate taskDate, Long userId);

    @Query("""
                select task
                from LearningTask task
                join fetch task.questions q
                where q.id = :questionId
                and task.userId = :userId
            """)
    Optional<LearningTask> findByQuestionIdAndUserId(Long questionId, Long userId);
}

