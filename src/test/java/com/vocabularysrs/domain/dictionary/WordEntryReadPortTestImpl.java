package com.vocabularysrs.domain.dictionary;

import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class WordEntryReadPortTestImpl implements WordEntryReadPort {

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateLessThanEqual(final LocalDate today) {
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
}
