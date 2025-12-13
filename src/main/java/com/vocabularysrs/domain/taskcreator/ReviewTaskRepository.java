package com.vocabularysrs.domain.taskcreator;

import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.Optional;

interface ReviewTaskRepository extends Repository<ReviewTask, Long> {

    Optional<ReviewTask> findByTaskDate(LocalDate taskDate);

    ReviewTask save(ReviewTask newWord);

}
