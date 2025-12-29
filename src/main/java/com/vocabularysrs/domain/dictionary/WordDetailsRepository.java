package com.vocabularysrs.domain.dictionary;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface WordDetailsRepository extends Repository<WordDetailsEntry, Long> {
    WordDetailsEntry save(WordDetailsEntry wordDetailsEntry);

    Optional<WordDetailsEntry> findById(Long id);

}
