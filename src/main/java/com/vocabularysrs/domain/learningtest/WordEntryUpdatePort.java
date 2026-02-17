package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;

public interface WordEntryUpdatePort {
    void update(DailyTestResponseDto result);
}


