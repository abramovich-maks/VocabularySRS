package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.learningtest.UserReadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class UserRepositoryAdapter implements UserReadPort {

    private final UserRepository userRepository;

    @Override
    public User getReferenceById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}