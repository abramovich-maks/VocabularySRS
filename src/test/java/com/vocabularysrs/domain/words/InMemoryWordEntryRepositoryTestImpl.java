package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.AdjustableClock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryWordEntryRepositoryTestImpl implements WordEntryRepository {


    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
            LocalDate.of(2025, 1, 1),
            LocalTime.of(12, 0),
            ZoneId.systemDefault()
    );

    Map<Long, WordEntry> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public WordEntry save(final WordEntry wordEntry) {
        if (wordEntry.getId() == null) {
            wordEntry.initialize(clock.today());
            long id = index.getAndIncrement();
            wordEntry.setId(id);
            database.put(id, wordEntry);
        } else {
            database.put(wordEntry.getId(), wordEntry);
        }
        return wordEntry;
    }

    @Override
    public boolean existsByWordAndUserId(final String word, final Long userId) {
        for (WordEntry entry : database.values()) {
            if (entry.getWord().equals(word) && entry.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsByIdAndUserId(final Long id, final Long userId) {
        return Optional.ofNullable(database.get(id))
                .map(entry -> entry.getUserId().equals(userId))
                .orElse(false);
    }

    @Override
    public Page<WordEntry> findAllByUserId(Long userId, Pageable pageable) {

        List<WordEntry> filtered = database.values().stream()
                .filter(entry -> userId.equals(entry.getUserId()))
                .sorted(Comparator.comparing(WordEntry::getId))
                .toList();

        if (pageable.isUnpaged()) {
            return new PageImpl<>(filtered);
        }

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), filtered.size());

        List<WordEntry> pageContent =
                start >= filtered.size()
                        ? List.of()
                        : filtered.subList(start, end);

        return new PageImpl<>(pageContent, pageable, filtered.size());
    }

    @Override
    public Optional<WordEntry> findByIdAndUserId(final Long id, final Long userId) {
        return Optional.ofNullable(database.get(id))
                .filter(entry -> userId.equals(entry.getUserId()));
    }

    @Override
    public List<WordEntry> findWordEntriesByNextReviewDateLessThanEqual(
            final LocalDate date,
            final Long userId
    ) {
        List<WordEntry> result = new ArrayList<>();

        for (WordEntry entry : database.values()) {
            if (
                    userId.equals(entry.getUserId()) &&
                            entry.getNextReviewDate() != null &&
                            !entry.getNextReviewDate().isAfter(date)
            ) {
                result.add(entry);
            }
        }
        return result;
    }


    @Override
    public void delete(final WordEntry word) {
        database.remove(word.getId());
    }

    @Override
    public Optional<WordEntry> findById(final Long wordId) {
        return Optional.ofNullable(database.get(wordId));
    }

    @Override
    public List<WordEntry> findAllByUserIdAndGroup_Id(Long userId, Long groupId) {
        return database.values().stream()
                .filter(w -> userId.equals(w.getUserId()))
                .filter(w -> w.getGroup() != null && w.getGroup().getId().equals(groupId))
                .toList();
    }
}
