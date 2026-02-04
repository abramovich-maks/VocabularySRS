package com.vocabularysrs.domain.words;

import org.springframework.data.repository.Repository;

interface WordGroupLinkRepository extends Repository<WordGroupLink, Long> {

    void deleteByGroup_Id(Long groupId);
}