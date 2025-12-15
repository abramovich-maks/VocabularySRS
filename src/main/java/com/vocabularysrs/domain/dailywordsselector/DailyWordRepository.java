package com.vocabularysrs.domain.dailywordsselector;

import org.springframework.data.repository.Repository;

interface DailyWordRepository extends Repository<DailyWordReview, Long> {

    DailyWordReview save(DailyWordReview newWord);

}
