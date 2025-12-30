package com.vocabularysrs.domain.dictionary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface WordDetailsRepository extends Repository<WordDetailsEntry, Long> {
    WordDetailsEntry save(WordDetailsEntry wordDetailsEntry);

    @Query("""
                select d from WordDetailsEntry d
                join d.wordEntry w
                where d.id = :id and w.userId = :userId
            """)
    Optional<WordDetailsEntry> findByIdAndUserId(Long id, Long userId);
}
