package com.vocabularysrs.domain.words;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

interface WordEntryRepository extends Repository<WordEntry, Long> {
    WordEntry save(WordEntry newWord);

    boolean existsByWordAndUserId(String word, Long userId);

    boolean existsByIdAndUserId(Long id, Long userId);

    Page<WordEntry> findAllByUserId(Long userId, Pageable pageable);

    @Query("SELECT s FROM WordEntry s WHERE s.id = :id AND s.userId = :userId")
    Optional<WordEntry> findByIdAndUserId(Long id, Long userId);

    @Query("SELECT s FROM WordEntry s WHERE s.userId=:userId AND s.nextReviewDate<=:nextReviewDate")
    List<WordEntry> findWordEntriesByNextReviewDateLessThanEqual(LocalDate nextReviewDate, Long userId);

    void delete(WordEntry word);

    Optional<WordEntry> findById(Long wordId);

    List<WordEntry> findAllByUserIdAndGroup_Id(Long userId, Long groupId);
}
