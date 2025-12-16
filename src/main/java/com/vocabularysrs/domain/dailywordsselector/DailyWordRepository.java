package com.vocabularysrs.domain.dailywordsselector;

import org.springframework.data.repository.Repository;

import java.util.List;

interface DailyWordRepository extends Repository<DailyWordReview, Long> {

    DailyWordReview save(DailyWordReview newWord);

    List<DailyWordReview> findDailyWordReviewByUserId(Long userId);
}
