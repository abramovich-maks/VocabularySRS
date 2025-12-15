package com.vocabularysrs.domain.dictionary;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Component
class WordEntryJpaAdapter implements WordEntryReadPort {

    private final WordEntryRepository repository;

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDate(final LocalDate today) {
        return repository.findWordEntriesByNextReviewDate(today)
                .stream()
                .map(wordEntry -> new WordEntrySnapshot(
                        wordEntry.getId(),
                        wordEntry.getUserId(),
                        wordEntry.getWord(),
                        wordEntry.getTranslate()
                ))
                .toList();
    }
}
