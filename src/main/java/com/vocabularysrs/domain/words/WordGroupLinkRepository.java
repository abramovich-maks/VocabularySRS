package com.vocabularysrs.domain.words;

import org.springframework.data.repository.Repository;

interface WordGroupLinkRepository extends Repository<WordGroupLink, Long> {

    WordGroupLink save(WordGroupLink link);

    void deleteByGroup_Id(Long groupId);

    boolean existsByWord_IdAndGroup_Id(Long wordId, Long id);
}