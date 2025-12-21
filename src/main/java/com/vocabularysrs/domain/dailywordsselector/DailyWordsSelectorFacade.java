package com.vocabularysrs.domain.dailywordsselector;

import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.dictionary.WordEntrySnapshot;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Log4j2
public class DailyWordsSelectorFacade {

    private final WordEntryReadPort wordEntryReadPort;
    private final DailyWordRepository dailyWordRepository;

    private final AdjustableClock clock;

    public void retrieveWordsByDate() {
        LocalDate today = clock.today();

        Map<Long, List<WordEntrySnapshot>> wordsByUser = new HashMap<>();
        for (WordEntrySnapshot word : wordEntryReadPort.findWordEntriesByNextReviewDate(today)) {
            wordsByUser
                    .computeIfAbsent(word.userId(), user -> new ArrayList<>())
                    .add(word);
        }

        for (Map.Entry<Long, List<WordEntrySnapshot>> entry : wordsByUser.entrySet()) {
            Long userId = entry.getKey();
            List<WordEntrySnapshot> userWords = entry.getValue();

            DailyWordReview dailyWordReview = new DailyWordReview();
            dailyWordReview.setTaskDate(today);
            dailyWordReview.setUserId(userId);

            for (WordEntrySnapshot word : userWords) {
                dailyWordReview.addItem(new ReviewWordItem(
                        word.id(),
                        word.word(),
                        word.translate()
                ));
            }
            dailyWordRepository.save(dailyWordReview);
            log.info("Created DailyWordReview for user {} with {} items", userId, userWords.size());
        }
    }
}