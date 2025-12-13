package com.vocabularysrs.domain.taskcreator;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.dictionary.WordEntrySnapshot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class WordEntryReadPortTestImpl implements WordEntryReadPort {

    @Override
    public List<WordEntrySnapshot> findWordsForReview(final LocalDate date) {
        List<WordEntrySnapshot> testImpl = new ArrayList<>();
        WordEntrySnapshot word1 = new WordEntrySnapshot(0L, "cat", "кот");
        WordEntrySnapshot word2 = new WordEntrySnapshot(1L, "dog", "собака");
        testImpl.add(word1);
        testImpl.add(word2);
        return testImpl;
    }
}
