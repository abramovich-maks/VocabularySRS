package com.vocabularysrs.domain.globalwords;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

class ExampleRepositoryTestImpl implements ExampleRepository {

    private final List<WordExample> database = new ArrayList<>();
    private final AtomicLong index = new AtomicLong(1);

    @Override
    public WordExample save(WordExample example) {

        if (example.getId() == null) {
            example.setId(index.getAndIncrement());
        }

        database.add(example);

        return example;
    }

    @Override
    public List<WordExample> findByWord(GlobalWord word) {

        return database.stream()
                .filter(e -> e.getWord().equals(word))
                .toList();
    }
}
