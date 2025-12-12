package com.vocabularysrs.domain.dictionary;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryWordEntryRepositoryTestImpl implements WordEntryRepository {

    Map<Long, WordEntry> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    public WordEntry save(final WordEntry wordEntry) {
        long index = this.index.getAndIncrement();
        database.put(index, wordEntry);
        wordEntry.setId(index);
        return wordEntry;
    }

    @Override
    public boolean existsByWord(final String word) {
        for (WordEntry entry : database.values()) {
            if (entry.getWord().equals(word)) {
                return true;
            }
        }
        return false;
    }
}
