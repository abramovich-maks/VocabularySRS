package com.vocabularysrs.domain.security;

import com.vocabularysrs.domain.shared.Language;

public interface CurrentUserProvider {
    Long getCurrentUserId();

    Language getCurrentUserLanguage();
}