package com.vocabularysrs.domain.worddetails;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface WordDetailsRepository extends Repository<WordDetailsEntry, Long> {
    WordDetailsEntry save(WordDetailsEntry wordDetailsEntry);

    Optional<WordDetailsEntry> findByWordIdAndUserId(Long wordId, Long userId);

    void deleteById(Long id);

}
