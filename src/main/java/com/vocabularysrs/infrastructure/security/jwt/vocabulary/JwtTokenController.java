package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vocabularysrs.domain.loginandregister.SecurityUser;
import com.vocabularysrs.domain.loginandregister.UserDetailsService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
class JwtTokenController {

    private final JwtTokenGenerator tokenGenerator;
    private final JwtConfigurationProperties properties;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenValidator jwtTokenValidator;

    @PostMapping("/token")
    public ResponseEntity<JwtResponseDto> login(@RequestBody @Valid TokenRequestDto dto, HttpServletResponse response) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));
        SecurityUser user = (SecurityUser) auth.getPrincipal();
        String accessToken = tokenGenerator.generateAccessToken(user);
        String refreshToken = tokenGenerator.generateRefreshToken(user);
        Cookie refreshCookie = new Cookie("refreshToken", refreshToken);
        refreshCookie.setHttpOnly(true);
        refreshCookie.setSecure(false);
        refreshCookie.setPath("/token/refresh");
        refreshCookie.setMaxAge((int) properties.refreshExpirationSeconds());
        response.addCookie(refreshCookie);
        return ResponseEntity.ok(
                JwtResponseDto.builder()
                        .token(accessToken)
                        .build());
    }


    @PostMapping("/token/refresh")
    public ResponseEntity<JwtResponseDto> refresh(HttpServletRequest request) {
        String refreshToken = extractRefreshToken(request);
        if (refreshToken == null) {
            return ResponseEntity.status(401).build();
        }
        try {
            DecodedJWT decodedJWT = jwtTokenValidator.verifyRefreshToken(refreshToken);
            String username = decodedJWT.getSubject();
            SecurityUser user = (SecurityUser) userDetailsService.loadUserByUsername(username);
            String newAccessToken = tokenGenerator.generateAccessToken(user);
            return ResponseEntity.ok(
                    JwtResponseDto.builder()
                            .token(newAccessToken)
                            .build());
        } catch (JWTVerificationException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        Cookie refreshCookie = new Cookie("refreshToken", "");
        refreshCookie.setHttpOnly(true);
        refreshCookie.setSecure(false);
        refreshCookie.setPath("/token/refresh");
        refreshCookie.setMaxAge(0);
        response.addCookie(refreshCookie);
        return ResponseEntity.ok().build();
    }

    private String extractRefreshToken(HttpServletRequest request) {
        if (request.getCookies() == null) return null;
        for (Cookie cookie : request.getCookies()) {
            if ("refreshToken".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}