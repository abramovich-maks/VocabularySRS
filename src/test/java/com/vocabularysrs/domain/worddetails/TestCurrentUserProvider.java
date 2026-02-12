package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.shared.Language;
import com.vocabularysrs.domain.security.CurrentUserProvider;

class TestCurrentUserProvider implements CurrentUserProvider {
    private Long userId = 1L;

    @Override
    public Long getCurrentUserId() {
        return userId;
    }

    @Override
    public Language getCurrentUserLanguage() {
        return Language.RU;
    }
}
