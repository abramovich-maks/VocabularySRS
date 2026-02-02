package com.vocabularysrs.domain.words;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface WordsGroupRepository extends Repository<WordsGroup, Long> {
    WordsGroup save(WordsGroup group);

    boolean existsByGroupNameAndUserId(String groupName, Long userId);

    @Query("SELECT s FROM WordsGroup s WHERE s.id = :id AND s.userId = :userId")
    Optional<WordsGroup> findByIdAndUserId(Long id, Long userId);

    void delete(WordsGroup group);
}
