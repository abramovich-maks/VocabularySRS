package com.vocabularysrs.domain.words;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryWordsGroupRepositoryTestImpl implements WordsGroupRepository {

    Map<Long, WordsGroup> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public WordsGroup save(final WordsGroup group) {
        if (group.getId() == null) {
            long id = index.getAndIncrement();
            group.setId(id);
            database.put(id, group);
        } else {
            database.put(group.getId(), group);
        }
        return group;
    }

    @Override
    public boolean existsByGroupNameAndUserId(final String groupName, final Long userId) {
        for (WordsGroup group : database.values()) {
            if (group.getGroupName().equals(groupName) && group.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }
}
