package com.vocabularysrs.domain.words;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WordEntryReadPort {
    List<WordEntrySnapshot> findWordEntriesByNextReviewDateLessThanEqual(LocalDate today);

    Optional<WordEntrySnapshot> findById(Long wordId);
}
