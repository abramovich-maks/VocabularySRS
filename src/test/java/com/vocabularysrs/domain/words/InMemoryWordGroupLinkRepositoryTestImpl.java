package com.vocabularysrs.domain.words;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryWordGroupLinkRepositoryTestImpl implements WordGroupLinkRepository {

    Map<Long, WordGroupLink> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public WordGroupLink save(final WordGroupLink link) {
        long id = index.getAndIncrement();
        database.put(id, link);
        return link;
    }

    @Override
    public boolean existsByWord_IdAndGroup_Id(Long wordId, Long groupId) {
        for (WordGroupLink entry : database.values()) {
            if (entry.getWord().getId().equals(wordId) && entry.getGroup().getId().equals(groupId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<WordGroupLink> findAllWithWordByGroupId(final Long groupId) {
        return List.of();
    }

    @Override
    public void deleteByGroup_Id(Long groupId) {
        database.remove(groupId);
    }
}

