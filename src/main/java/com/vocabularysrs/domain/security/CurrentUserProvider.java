package com.vocabularysrs.domain.security;

import com.vocabularysrs.domain.loginandregister.UserLanguage;

public interface CurrentUserProvider {
    Long getCurrentUserId();

    UserLanguage getCurrentUserLanguage();
}