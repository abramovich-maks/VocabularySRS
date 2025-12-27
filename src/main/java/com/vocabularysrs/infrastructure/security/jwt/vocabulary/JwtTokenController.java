package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
class JwtTokenController {

    private final JwtTokenGenerator tokenGenerator;

    @PostMapping("/token")
    public ResponseEntity<JwtResponseDto> authenticateAndGenerateToken(@RequestBody @Valid TokenRequestDto dto, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        String token = tokenGenerator.authenticateAndGenerateToken(dto.email(), dto.password());
        Cookie cookie = new Cookie("accessToken", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return ResponseEntity.ok().body(
                JwtResponseDto.builder()
                        .token(token)
                        .build()
        );
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Boolean>> status(Authentication authentication) {
        return ResponseEntity.ok(Map.of(
                "loggedIn", authentication != null && authentication.isAuthenticated()
        ));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("accessToken", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok().build();
    }
}