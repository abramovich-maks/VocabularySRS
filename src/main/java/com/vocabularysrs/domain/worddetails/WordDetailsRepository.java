package com.vocabularysrs.domain.worddetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface WordDetailsRepository extends Repository<WordDetailsEntry, Long> {
    WordDetailsEntry save(WordDetailsEntry wordDetailsEntry);

    @Query("select s from WordDetailsEntry s " +
            "left join fetch s.alternatives " +
            "where s.wordId = :wordId AND s.userId = :userId")
    Optional<WordDetailsEntry> findByWordIdAndUserId(Long wordId, Long userId);

    void deleteByWordIdAndUserId(Long wordId, Long userId);
}
