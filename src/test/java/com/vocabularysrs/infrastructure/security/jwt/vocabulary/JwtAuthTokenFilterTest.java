package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vocabularysrs.domain.loginandregister.SecurityUser;
import com.vocabularysrs.domain.shared.Language;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class JwtAuthTokenFilterTest {

    KeyPair keyPair;
    JwtAuthTokenFilter filter;

    @BeforeEach
    void setUp() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        keyPair = generator.generateKeyPair();
        Clock clock = Clock.fixed(
                Instant.parse("2025-12-19T10:00:00Z"),
                ZoneOffset.UTC
        );
        JwtTokenValidator validator = new JwtTokenValidator(keyPair, clock);
        filter = new JwtAuthTokenFilter(validator);
    }

    @AfterEach
    void clearContext() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void shouldAuthenticateUserWhenJwtIsValid() throws Exception {
        // given
        String token = JWT.create()
                .withSubject("test@email.com")
                .withIssuer("VocabularySRS-backend")
                .withClaim("type", "access")
                .withClaim("userId", 1L)
                .withClaim("language", "RU")
                .withIssuedAt(Date.from(Instant.parse("2025-12-19T09:59:00Z")))
                .withExpiresAt(Date.from(Instant.parse("2025-12-19T10:30:00Z")))
                .sign(Algorithm.RSA256(null, (RSAPrivateKey) keyPair.getPrivate()));

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer " + token);

        // when
        filter.doFilter(request, new MockHttpServletResponse(), new MockFilterChain());

        // then
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assertNotNull(auth);

        SecurityUser principal = (SecurityUser) auth.getPrincipal();
        assertEquals(1L, principal.getUserId());
        assertEquals(Language.RU, principal.getUserLanguage());
        assertEquals("test@email.com", principal.getUsername());
    }

    @Test
    void shouldReadTokenFromAuthorizationHeader() throws Exception {
        // given
        String token = JWT.create()
                .withSubject("user@u")
                .withIssuer("VocabularySRS-backend")
                .withClaim("type", "access")
                .withClaim("userId", 5L)
                .withClaim("language", "RU")
                .withIssuedAt(Date.from(Instant.parse("2025-12-19T09:59:00Z")))
                .withExpiresAt(Date.from(Instant.parse("2025-12-19T10:30:00Z")))
                .sign(Algorithm.RSA256(null, (RSAPrivateKey) keyPair.getPrivate()));

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer " + token);

        // when
        filter.doFilter(request, new MockHttpServletResponse(), new MockFilterChain());

        // then
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    void shouldNotAuthenticateWhenJwtIsInvalid() throws Exception {
        // given
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer invalid-token");

        // when
        filter.doFilter(request, new MockHttpServletResponse(), new MockFilterChain());

        // then
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    void shouldSkipAuthenticationWhenNoTokenProvided() throws Exception {
        // given
        MockHttpServletRequest request = new MockHttpServletRequest();

        // when
        filter.doFilter(request, new MockHttpServletResponse(), new MockFilterChain());

        // then
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }
}