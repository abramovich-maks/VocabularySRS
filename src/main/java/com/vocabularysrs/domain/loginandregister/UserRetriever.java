package com.vocabularysrs.domain.loginandregister;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
class UserRetriever {

    private final UserRepository userRepository;

    public void existsByEmail(final String email) {
        boolean emailExists = userRepository.existsByEmail(email);
        if (emailExists) {
            throw new UserAlreadyExistException(email);
        }
    }

    public UserDtoResponse findByEmail(String email) {
        User userFound = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found "));
        return UserDtoResponse.builder()
                .email(userFound.getEmail())
                .password(userFound.getPasswordHash())
                .build();
    }
}