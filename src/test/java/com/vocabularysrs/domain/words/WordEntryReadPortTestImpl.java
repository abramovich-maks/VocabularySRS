package com.vocabularysrs.domain.words;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class WordEntryReadPortTestImpl implements WordEntryReadPort {

    private final Map<Long, WordEntrySnapshot> data = new HashMap<>();

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateAndUserIdLessThanEqual(final LocalDate today, final Long userId) {
        List<WordEntrySnapshot> testImpl = new ArrayList<>();
        Long userId1 = 1L;
        Long userId2 = 2L;
        WordEntrySnapshot word1 = new WordEntrySnapshot(1L, userId1, "cat", "кот");
        WordEntrySnapshot word2 = new WordEntrySnapshot(2L, userId1, "dog", "собака");
        WordEntrySnapshot word3 = new WordEntrySnapshot(3L, userId2, "sun", "солнце");
        testImpl.add(word1);
        testImpl.add(word2);
        testImpl.add(word3);
        return testImpl;
    }

    @Override
    public Optional<WordEntrySnapshot> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }
}
