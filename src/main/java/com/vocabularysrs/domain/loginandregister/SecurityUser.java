package com.vocabularysrs.domain.loginandregister;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class SecurityUser implements UserDetails {

    private final Long userId;
    private final UserLanguage userLanguage;
    private final String username;
    private final String passwordHash;


    public SecurityUser(Long userId, UserLanguage userLanguage, String username, final String passwordHash) {
        this.userId = userId;
        this.userLanguage = userLanguage;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Long getUserId() {
        return userId;
    }

    public UserLanguage getUserLanguage() {
        return userLanguage;
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
