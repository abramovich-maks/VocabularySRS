package com.vocabularysrs;

import com.vocabularysrs.infrastructure.security.jwt.vocabulary.JwtResponseDto;
import com.vocabularysrs.infrastructure.security.jwt.vocabulary.TokenRequestDto;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@Profile("integration")
class TestJwtTokenController {

    @PostMapping
    public ResponseEntity<JwtResponseDto> fakeToken(@RequestBody TokenRequestDto dto) {
        return ResponseEntity.ok(
                JwtResponseDto.builder()
                        .token("test-token")
                        .build()
        );
    }
}

