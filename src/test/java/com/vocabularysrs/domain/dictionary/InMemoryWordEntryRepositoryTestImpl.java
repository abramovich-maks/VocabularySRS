package com.vocabularysrs.domain.dictionary;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    @Override
    public boolean existsById(final Long id) {
        return database.containsKey(id);
    }

    @Override
    public void deleteById(final Long id) {
        database.remove(id);
    }

    @Override
    public List<WordEntry> findAll(final Pageable pageable) {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<WordEntry> findById(final Long id) {
        return Optional.ofNullable(database.get(id));
    }
}
