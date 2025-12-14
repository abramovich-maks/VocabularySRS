package com.vocabularysrs.domain.loginandregister;

class UserMapper {

    public static UserRegisterResponseDto mapFromUserToUserRegisterResponseDto(final User savedUser) {
        return UserRegisterResponseDto.builder()
                .userId(savedUser.getId())
                .username(savedUser.getUsername())
                .surname(savedUser.getSurname())
                .email(savedUser.getEmail())
                .message("User created successful!")
                .build();
    }
}
