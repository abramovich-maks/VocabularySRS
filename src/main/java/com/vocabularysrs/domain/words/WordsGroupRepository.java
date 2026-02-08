package com.vocabularysrs.domain.words;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface WordsGroupRepository extends Repository<WordsGroup, Long> {
    WordsGroup save(WordsGroup group);

    boolean existsByGroupNameAndUserId(String groupName, Long userId);

    Optional<WordsGroup> findByIdAndUserId(Long id, Long userId);

    void delete(WordsGroup group);

    List<WordsGroup> findAllByUserId(Long userId);
}
