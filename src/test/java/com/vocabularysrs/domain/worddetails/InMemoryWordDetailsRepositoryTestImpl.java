package com.vocabularysrs.domain.worddetails;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryWordDetailsRepositoryTestImpl implements WordDetailsRepository {

    Map<String, WordDetailsEntry> database = new ConcurrentHashMap<>();
    private long index = 0;

    @Override
    public WordDetailsEntry save(WordDetailsEntry entry) {
        if (entry.getId() == null) {
            entry.setId(++index);
        }
        database.put(key(entry.getWordId(), entry.getUserId()), entry);
        return entry;
    }

    @Override
    public Optional<WordDetailsEntry> findByWordIdAndUserId(Long wordId, Long userId) {
        return Optional.ofNullable(database.get(key(wordId, userId)));
    }

    private String key(Long wordId, Long userId) {
        return wordId + ":" + userId;
    }

    @Override
    public void deleteById(Long id) {
        database.values().removeIf(e -> e.getId().equals(id));
    }
}
