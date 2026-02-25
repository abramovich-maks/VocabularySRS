package com.vocabularysrs.domain.globalwords;

import org.springframework.data.repository.Repository;

import java.util.List;

interface ExampleRepository extends Repository<WordExample, Long> {

    WordExample save(WordExample example);

    List<WordExample> findByWord(GlobalWord word);
}
