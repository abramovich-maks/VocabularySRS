package com.vocabularysrs.domain.words;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WordEntryReadPort {
    List<WordEntrySnapshot> findWordEntriesByNextReviewDateAndUserIdLessThanEqual(LocalDate today, Long userId);

    Optional<WordEntrySnapshot> findById(Long wordId);
}
