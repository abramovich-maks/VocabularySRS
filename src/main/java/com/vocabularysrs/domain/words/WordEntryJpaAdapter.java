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
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateLessThanEqual(final LocalDate today) {
        return repository.findWordEntriesByNextReviewDateLessThanEqual(today)
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
}
