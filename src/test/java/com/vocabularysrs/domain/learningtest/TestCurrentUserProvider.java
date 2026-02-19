package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.shared.Language;
import com.vocabularysrs.domain.security.CurrentUserProvider;

class TestCurrentUserProvider implements CurrentUserProvider {
    @Override
    public Long getCurrentUserId() {
        return 1L;
    }

    @Override
    public Language getCurrentUserLanguage() {
        return Language.RU;
    }
}
