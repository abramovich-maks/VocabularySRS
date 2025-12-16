package com.vocabularysrs.domain.dailywordsselector;

import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;

interface DailyWordRepository extends Repository<DailyWordReview, Long> {

    DailyWordReview save(DailyWordReview newWord);

    List<DailyWordReview> findDailyWordReviewByTaskDate(LocalDate taskDate);
}
