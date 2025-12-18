package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DailyTestFacade {

    private DailyTestChecker dailyTestChecker;

    public DailyTestResponseDto processDailyTest(DailyTestRequestDto request) {
        return dailyTestChecker.checkResult(request);
    }
}