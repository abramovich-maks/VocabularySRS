package com.vocabularysrs.domain.dictionary;

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
}
