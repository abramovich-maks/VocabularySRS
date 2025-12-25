package com.vocabularysrs.infrastructure.loginandregister;

import com.vocabularysrs.domain.loginandregister.LoginAndRegisterFacade;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping()
class LoginAndRegisterController {

    private final LoginAndRegisterFacade loginAndRegisterFacade;

    @PostMapping("/register")
    public UserRegisterResponseDto registerUser(@RequestBody @Valid UserRegisterRequestDto requestDto) {
        return loginAndRegisterFacade.registerUser(requestDto);
    }
}
