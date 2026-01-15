package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.loginandregister.UserLanguage;
import com.vocabularysrs.domain.security.CurrentUserProvider;

class TestCurrentUserProvider implements CurrentUserProvider {
    private Long userId = 1L;

    @Override
    public Long getCurrentUserId() {
        return userId;
    }

    @Override
    public UserLanguage getCurrentUserLanguage() {
        return UserLanguage.RU;
    }
}
