package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.shared.Language;
import com.vocabularysrs.domain.security.CurrentUserProvider;

class TestCurrentUserProvider implements CurrentUserProvider {
    private Long userId = 1L;

    void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getCurrentUserId() {
        return userId;
    }

    @Override
    public Language getCurrentUserLanguage() {
        return null;
    }
}
