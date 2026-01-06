package com.vocabularysrs.domain.learningtaskgenerator;


import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;

import java.time.LocalDate;
import java.util.List;

class DailyWordReadPortTwoUsersTestImpl implements WordEntryReadPort {

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateLessThanEqual(final LocalDate today) {
        return List.of(
                WordEntrySnapshot.builder()
                        .id(1L)
                        .userId(1L)
                        .word("cat")
                        .translate("кот")
                        .build(),
                WordEntrySnapshot.builder()
                        .id(2L)
                        .userId(2L)
                        .word("dog")
                        .translate("собака")
                        .build());
    }
}
