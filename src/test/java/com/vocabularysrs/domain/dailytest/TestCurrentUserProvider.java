package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.loginandregister.UserLanguage;
import com.vocabularysrs.domain.security.CurrentUserProvider;

class TestCurrentUserProvider implements CurrentUserProvider {
    @Override
    public Long getCurrentUserId() {
        return 1L;
    }

    @Override
    public UserLanguage getCurrentUserLanguage() {
        return UserLanguage.RU;
    }
}
