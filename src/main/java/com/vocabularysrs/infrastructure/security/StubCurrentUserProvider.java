package com.vocabularysrs.infrastructure.security;

import com.vocabularysrs.domain.security.CurrentUserProvider;

public class StubCurrentUserProvider implements CurrentUserProvider {

    @Override
    public Long getCurrentUserId() {
        return 1L;
    }
}