package com.vocabularysrs.domain.words;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface WordGroupLinkRepository extends Repository<WordGroupLink, Long> {

    WordGroupLink save(WordGroupLink link);

    void deleteByGroup_Id(Long groupId);

    boolean existsByWord_IdAndGroup_Id(Long wordId, Long id);

    @Query("""
                SELECT link
                FROM WordGroupLink link
                JOIN FETCH link.word
                WHERE link.group.id = :groupId
            """)
    List<WordGroupLink> findAllWithWordByGroupId(Long groupId);

}