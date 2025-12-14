package com.vocabularysrs.domain.loginandregister;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginAndRegisterFacade {

    private final UserAdder userAdder;

    public UserRegisterResponseDto registerUser(UserRegisterRequestDto requestDto) {
        return userAdder.addUser(requestDto);
    }
}
