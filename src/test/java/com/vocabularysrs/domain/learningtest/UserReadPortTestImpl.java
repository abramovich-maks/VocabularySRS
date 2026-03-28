package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.loginandregister.User;
import com.vocabularysrs.domain.shared.Language;

class UserReadPortTestImpl implements UserReadPort {
    @Override
    public User getReferenceById(final Long userId) {
        return User.builder().id(1L).username("Maksim").surname("Abramovich").email("test@mail.gmail.com").passwordHash("1234").language(Language.RU).confirmationToken(null).enabled(true).build();
    }
}
