package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.loginandregister.User;

public interface UserReadPort {
    User getReferenceById(Long userId);
}
