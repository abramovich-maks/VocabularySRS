package com.vocabularysrs.domain.words;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
class WordEntryJpaAdapter implements WordEntryReadPort {

    private final WordEntryRepository repository;

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateAndUserIdLessThanEqual(final LocalDate today, Long userId) {
        return repository.findWordEntriesByNextReviewDateLessThanEqual(today, userId)
                .stream()
                .map(wordEntry -> new WordEntrySnapshot(
                        wordEntry.getId(),
                        wordEntry.getUserId(),
                        wordEntry.getWord(),
                        wordEntry.getTranslate()
                ))
                .toList();
    }

    @Override
    public Optional<WordEntrySnapshot> findById(Long wordId) {
        return repository.findById(wordId)
                .map(wordEntry -> new WordEntrySnapshot(
                        wordEntry.getId(),
                        wordEntry.getUserId(),
                        wordEntry.getWord(),
                        wordEntry.getTranslate()
                ));
    }

    @Override
    public Optional<LocalDate> findNearestReviewDate(Long userId) {
        return Optional.ofNullable(repository.findNearestReviewDate(userId, LocalDate.now()));
    }
}
