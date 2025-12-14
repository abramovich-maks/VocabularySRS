package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.loginandregister.dto.UserLoginRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserLoginResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
class UserLoginChecker {

    private final UserRetriever userRetriever;
    private final PasswordEncoder passwordEncoder;

    UserLoginResponseDto login(UserLoginRequestDto requestDto) {
        UserDtoResponse userDetails = userRetriever.findByEmail(requestDto.email());
        boolean matches = passwordEncoder.matches(
                requestDto.password(),
                userDetails.password()
        );
        if (!matches) {
            return UserLoginResponseDto.builder()
                    .message("Login failed")
                    .build();
        }
        return UserLoginResponseDto.builder()
                .message("Login successful")
                .build();
    }
}
