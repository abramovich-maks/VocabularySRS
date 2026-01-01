package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;

class DictionaryUpdatePortTestImpl implements DictionaryUpdatePort {
    DailyTestResponseDto lastUpdate;

    @Override
    public void update(DailyTestResponseDto result) {
        this.lastUpdate = result;
    }
}
