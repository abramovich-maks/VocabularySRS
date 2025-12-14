package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.loginandregister.dto.UserRegisterResponseDto;

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
