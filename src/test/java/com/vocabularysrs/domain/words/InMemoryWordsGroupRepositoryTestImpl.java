package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.words.dto.WordsGroupDtoRequest;
import org.flywaydb.core.api.output.InfoResult;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    @Override
    public Optional<WordsGroup> findByIdAndUserId(final Long id, final Long userId) {
        return Optional.ofNullable(database.get(id))
                .filter(entry -> userId.equals(entry.getUserId()));
    }

    @Override
    public void delete(final WordsGroup group) {
        database.remove(group.getId());
    }

    @Override
    public List<WordsGroup> findAllByUserId(Long userId) {
        return database.values().stream()
                .filter(g -> g.getUserId().equals(userId))
                .toList();
    }
}
