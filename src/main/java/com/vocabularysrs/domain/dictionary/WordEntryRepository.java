package com.vocabularysrs.domain.dictionary;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

interface WordEntryRepository extends Repository<WordEntry, String> {
    WordEntry save(WordEntry newWord);

    boolean existsByWord(String word);

    boolean existsById(Long id);

    @Modifying
    @Query("DELETE FROM WordEntry s WHERE s.id = :id")
    void deleteById(Long id);
}
