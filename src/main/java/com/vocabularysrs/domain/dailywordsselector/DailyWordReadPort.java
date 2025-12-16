package com.vocabularysrs.domain.dailywordsselector;

import java.util.List;

public interface DailyWordReadPort {
    List<DailyWordSnapshot> findDailyWordByUserId(Long userId);

}
