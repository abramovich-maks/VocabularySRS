package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vocabularysrs.domain.loginandregister.SecurityUser;
import com.vocabularysrs.domain.loginandregister.UserLanguage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.time.Clock;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtTokenGeneratorTest {

    @Mock
    Clock clock;

    @Mock
    JwtConfigurationProperties properties;

    @Test
    void should_generate_valid_jwt_token() throws Exception {
        // given
        Instant now = Instant.parse("2025-01-01T10:00:00Z");
        when(clock.instant()).thenReturn(now);

        when(properties.expirationSeconds()).thenReturn(1800L);
        when(properties.issuer()).thenReturn("VocabularySRS-backend");

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();

        JwtTokenGenerator jwtTokenGenerator =
                new JwtTokenGenerator(clock, properties, keyPair);

        SecurityUser securityUser = mock(SecurityUser.class);
        when(securityUser.getUsername()).thenReturn("email@test.com");
        when(securityUser.getUserId()).thenReturn(1L);
        when(securityUser.getUserLanguage()).thenReturn(UserLanguage.RU);

        // when
        String token = jwtTokenGenerator.generateAccessToken(securityUser);

        // then
        assertNotNull(token);

        DecodedJWT decoded = JWT.decode(token);
        assertEquals("email@test.com", decoded.getSubject());
        assertEquals("VocabularySRS-backend", decoded.getIssuer());
        assertEquals(now, decoded.getIssuedAt().toInstant());
        assertEquals(now.plusSeconds(1800), decoded.getExpiresAt().toInstant());
        assertEquals(1L, decoded.getClaim("userId").asLong());
        assertEquals("RU", decoded.getClaim("userLanguage").asString());
        assertEquals("access", decoded.getClaim("type").asString());
    }
}