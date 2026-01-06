package com.vocabularysrs.domain.words;

import java.time.LocalDate;
import java.util.List;

public interface WordEntryReadPort {
    List<WordEntrySnapshot> findWordEntriesByNextReviewDateLessThanEqual(LocalDate today);
}
