package com.vocabularysrs.domain.globalwords;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface GlobalWordsRepository extends Repository<GlobalWord, Long> {

    GlobalWord save(GlobalWord word);

    Optional<GlobalWord> findByWord(String word);
}
