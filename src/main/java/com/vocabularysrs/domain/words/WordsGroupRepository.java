package com.vocabularysrs.domain.words;

import org.springframework.data.repository.Repository;

interface WordsGroupRepository extends Repository<WordsGroup, Long> {
    WordsGroup save(WordsGroup group);

    boolean existsByGroupNameAndUserId(String groupName, Long userId);
}
