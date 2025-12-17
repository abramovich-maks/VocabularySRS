package com.vocabularysrs.domain.dailywordsselector;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;

interface DailyWordRepository extends Repository<DailyWordReview, Long> {

    DailyWordReview save(DailyWordReview newWord);

    @Query("""
            select word
            from DailyWordReview word
            join fetch word.items
            where word.taskDate = :taskDate
            """)
    List<DailyWordReview> findDailyWordReviewByTaskDate(LocalDate taskDate);
}
