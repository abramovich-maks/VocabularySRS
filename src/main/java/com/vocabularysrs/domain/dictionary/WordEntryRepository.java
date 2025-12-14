package com.vocabularysrs.domain.dictionary;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

interface WordEntryRepository extends Repository<WordEntry, Long> {
    WordEntry save(WordEntry newWord);

    boolean existsByWord(String word);

    boolean existsById(Long id);

    @Modifying
    @Query("DELETE FROM WordEntry s WHERE s.id = :id")
    void deleteById(Long id);

    List<WordEntry> findAll(Pageable pageable);

    @Query("SELECT s FROM WordEntry s WHERE s.id = :id")
    Optional<WordEntry> findById(Long id);

    List<WordEntry> findByNextReviewDate(LocalDate date);
}
