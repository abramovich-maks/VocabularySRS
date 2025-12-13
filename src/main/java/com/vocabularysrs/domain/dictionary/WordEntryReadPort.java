package com.vocabularysrs.domain.dictionary;

import java.time.LocalDate;
import java.util.List;

public interface WordEntryReadPort {
    List<WordEntrySnapshot> findWordsForReview(LocalDate date);
}
