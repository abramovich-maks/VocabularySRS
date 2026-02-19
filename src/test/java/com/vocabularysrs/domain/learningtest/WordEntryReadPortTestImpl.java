package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.words.WordEntryReadPort;
import com.vocabularysrs.domain.words.WordEntrySnapshot;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

class WordEntryReadPortTestImpl implements WordEntryReadPort {

    private List<WordEntrySnapshot> words = List.of();
    private Optional<LocalDate> nearestDate = Optional.empty();


    public void setWords(List<WordEntrySnapshot> words) {
        this.words = words;
    }

    public void setNearestDate(LocalDate date) {
        this.nearestDate = Optional.of(date);
    }

    @Override
    public List<WordEntrySnapshot> findWordEntriesByNextReviewDateAndUserIdLessThanEqual(final LocalDate today, final Long userId) {
        return words;
    }

    @Override
    public Optional<WordEntrySnapshot> findById(final Long wordId) {
        return Optional.empty();
    }

    @Override
    public Optional<LocalDate> findNearestReviewDate(final Long userId) {
        return nearestDate;
    }
}
