package com.vocabularysrs.domain.learningtaskgenerator;

import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.dictionary.WordEntrySnapshot;

import java.time.LocalDate;
import java.util.List;

public class WordEntryReadPortTestImpl implements WordEntryReadPort {

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateLessThanEqual(final LocalDate today) {
        return List.of(
                WordEntrySnapshot.builder()
                        .id(1L)
                        .userId(1L)
                        .word("cat")
                        .translate("кот")
                        .build());
    }
}