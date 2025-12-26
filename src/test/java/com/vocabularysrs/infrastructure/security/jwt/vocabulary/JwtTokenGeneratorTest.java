package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vocabularysrs.domain.loginandregister.SecurityUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtTokenGeneratorTest {

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    Clock clock;

    @Mock
    JwtConfigurationProperties properties;

    @Mock
    JwtKeyPairConfig keyPairConfig;

    @InjectMocks
    JwtTokenGenerator jwtTokenGenerator;


    @Test
    public void should_generate_valid_jwt_token() throws NoSuchAlgorithmException, IOException {
        String email = "email@test.com";
        String password = "password";

        SecurityUser securityUser = mock(SecurityUser.class);
        when(securityUser.getUsername()).thenReturn("email@test.com");

        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(securityUser);

        when(authenticationManager.authenticate(any()))
                .thenReturn(authentication);

        Instant now = Instant.parse("2025-01-01T10:00:00Z");
        when(clock.instant()).thenReturn(now);

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();

        when(keyPairConfig.keyPair()).thenReturn(keyPair);

        when(properties.expirationSeconds()).thenReturn(1800L);
        when(properties.issuer()).thenReturn("VocabularySRS-backend");

        // when
        String token = jwtTokenGenerator.authenticateAndGenerateToken(email, password);

        // then
        assertNotNull(token);

        DecodedJWT decoded = JWT.decode(token);
        assertEquals(email, decoded.getSubject());
        assertEquals("VocabularySRS-backend", decoded.getIssuer());
        assertTrue(decoded.getExpiresAt().after(decoded.getIssuedAt()));
    }
}