package com.vocabularysrs.domain.dailywordsselector;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
class DailyWordJpaAdapter implements DailyWordReadPort {

    private final DailyWordRepository repository;

    @Override
    public List<DailyWordSnapshot> findDailyWordByUserId(final Long userId) {
        return repository.findDailyWordReviewByUserId(userId)
                .stream()
                .map(dailyWord -> new DailyWordSnapshot(
                        dailyWord.getId(),
                        dailyWord.getUserId(),
                        dailyWord.getTaskDate(),
                        dailyWord.getItems().stream()
                                .map(item -> new ReviewWordItem(
                                        item.getWordEntryId(),
                                        item.getWord(),
                                        item.getTranslate()
                                ))
                                .toList()
                ))
                .toList();
    }
}