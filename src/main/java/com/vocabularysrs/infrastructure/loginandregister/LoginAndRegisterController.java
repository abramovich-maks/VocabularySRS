package com.vocabularysrs.infrastructure.loginandregister;

import com.vocabularysrs.domain.loginandregister.LoginAndRegisterFacade;
import com.vocabularysrs.domain.loginandregister.dto.UserLoginRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserLoginResponseDto;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping()
class LoginAndRegisterController {

    private final LoginAndRegisterFacade loginAndRegisterFacade;

    @PostMapping("/register")
    public UserRegisterResponseDto registerUser(@RequestBody UserRegisterRequestDto requestDto) {
        return loginAndRegisterFacade.registerUser(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto) {
        return loginAndRegisterFacade.login(requestDto);
    }
}
