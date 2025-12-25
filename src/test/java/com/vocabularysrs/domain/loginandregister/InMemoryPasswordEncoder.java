package com.vocabularysrs.domain.loginandregister;

import org.springframework.security.crypto.password.PasswordEncoder;

class InMemoryPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(final CharSequence rawPassword) {
        return new StringBuilder(rawPassword).reverse().toString();
    }

    @Override
    public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}

