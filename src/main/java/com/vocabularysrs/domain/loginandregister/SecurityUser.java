package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.shared.Language;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class SecurityUser implements UserDetails {

    private final Long userId;
    private final Language language;
    private final String username;
    private final String passwordHash;


    public SecurityUser(Long userId, Language language, String username, final String passwordHash) {
        this.userId = userId;
        this.language = language;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Long getUserId() {
        return userId;
    }

    public Language getUserLanguage() {
        return language;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
