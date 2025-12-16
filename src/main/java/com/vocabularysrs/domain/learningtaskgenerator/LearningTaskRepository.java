package com.vocabularysrs.domain.learningtaskgenerator;

import org.springframework.data.repository.Repository;

interface LearningTaskRepository extends Repository<LearningTask, Long> {
    LearningTask save(LearningTask task);
}

