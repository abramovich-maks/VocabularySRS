package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class WordEntryReadPortTestImpl implements WordEntryReadPort {

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateAndUserIdLessThanEqual(final LocalDate today, final Long userId) {
        return List.of(
                WordEntrySnapshot.builder()
                        .id(1L)
                        .userId(1L)
                        .word("cat")
                        .translate("кот")
                        .build());
    }

    @Override
    public Optional<WordEntrySnapshot> findById(final Long wordId) {
        return Optional.empty();
    }
}