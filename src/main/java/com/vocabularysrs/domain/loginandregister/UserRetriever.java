package com.vocabularysrs.domain.loginandregister;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
class UserRetriever {

    private final UserRepository userRepository;

    public boolean existsByEmail(final String email) {
        return userRepository.existsByEmail(email);
    }

}
