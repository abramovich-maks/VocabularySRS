package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.loginandregister.dto.UserLoginRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserLoginResponseDto;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginAndRegisterFacade {

    private final UserAdder userAdder;
    private final UserLoginChecker userLoginChecker;
    private final UserRetriever userRetriever;

    public UserRegisterResponseDto registerUser(UserRegisterRequestDto requestDto) {
        return userAdder.addUser(requestDto);
    }

    public UserLoginResponseDto login(UserLoginRequestDto requestDto) {
        return userLoginChecker.login(requestDto);
    }

    public UserDtoResponse findByEmail(String email) {
        return userRetriever.findByEmail(email);
    }
}
