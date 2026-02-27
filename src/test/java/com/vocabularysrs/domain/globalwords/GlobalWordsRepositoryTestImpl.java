package com.vocabularysrs.domain.globalwords;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

class GlobalWordsRepositoryTestImpl implements GlobalWordsRepository {

    private final Map<String, GlobalWord> database = new ConcurrentHashMap<>();
    private final AtomicLong index = new AtomicLong(1);

    @Override
    public GlobalWord save(GlobalWord word) {

        if (word.getId() == null) {
            word.setId(index.getAndIncrement());
        }

        database.put(word.getWord(), word);

        return word;
    }

    @Override
    public Optional<GlobalWord> findByWord(String word) {
        return Optional.ofNullable(database.get(word));
    }
}
