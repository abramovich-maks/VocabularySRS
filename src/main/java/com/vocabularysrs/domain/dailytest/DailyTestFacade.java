package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class DailyTestFacade {

    private DailyTestChecker dailyTestChecker;
    private final CurrentUserProvider currentUserProvider;
    private final DictionaryUpdatePort dictionaryUpdatePort;


    public DailyTestResponseDto processDailyTest(DailyTestRequestDto request) {
        Long userId = currentUserProvider.getCurrentUserId();
        LocalDate today = LocalDate.now();
        DailyTestResponseDto response = dailyTestChecker.checkResult(userId, today, request.answers());
        dictionaryUpdatePort.update(response);
        return response;
    }
}