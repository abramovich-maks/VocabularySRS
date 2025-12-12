package com.vocabularysrs.domain.dictionary;

import org.springframework.data.repository.Repository;

interface WordEntryRepository extends Repository<WordEntry, String> {
    WordEntry save(WordEntry newWord);

    boolean existsByWord(String word);
}
