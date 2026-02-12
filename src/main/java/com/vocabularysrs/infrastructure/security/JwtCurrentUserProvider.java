package com.vocabularysrs.infrastructure.security;

import com.vocabularysrs.domain.loginandregister.SecurityUser;
import com.vocabularysrs.domain.shared.Language;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtCurrentUserProvider implements CurrentUserProvider {

    @Override
    public Long getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser principal = (SecurityUser) auth.getPrincipal();
        return principal.getUserId();
    }

    @Override
    public Language getCurrentUserLanguage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser principal = (SecurityUser) auth.getPrincipal();
        return principal.getUserLanguage();
    }
}