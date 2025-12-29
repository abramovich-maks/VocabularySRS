package com.vocabularysrs.domain.dictionary;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryWordDetailsRepositoryTestImpl implements WordDetailsRepository {

    Map<Long, WordDetailsEntry> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public WordDetailsEntry save(final WordDetailsEntry wordEntry) {
        if (wordEntry.getId() == null) {
            long id = index.getAndIncrement();
            wordEntry.setId(id);
            database.put(id, wordEntry);
        } else {
            database.put(wordEntry.getId(), wordEntry);
        }
        return wordEntry;
    }

    @Override
    public Optional<WordDetailsEntry> findById(final Long id) {
        return Optional.ofNullable(database.get(id));
    }

}
