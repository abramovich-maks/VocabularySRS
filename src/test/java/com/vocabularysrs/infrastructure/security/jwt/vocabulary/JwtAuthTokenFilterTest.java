package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vocabularysrs.domain.loginandregister.UserDetailsService;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtAuthTokenFilterTest {


    @Mock
    UserDetailsService userDetailsService;

    KeyPair keyPair;

    JwtAuthTokenFilter filter;

    @BeforeEach
    void setUp() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        keyPair = generator.generateKeyPair();
        filter = new JwtAuthTokenFilter(keyPair, userDetailsService);
    }

    @AfterEach
    void clearContext() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void shouldAuthenticateUserWhenJwtIsValid() throws Exception {
        // given
        String username = "test@email.com";

        String token = JWT.create()
                .withSubject(username)
                .sign(Algorithm.RSA256(null, (RSAPrivateKey) keyPair.getPrivate()));

        UserDetails userDetails = mock(UserDetails.class);
        when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer " + token);

        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        // when
        filter.doFilter(request, response, filterChain);
        // then
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assertNotNull(authentication);
        Assertions.assertEquals(userDetails, authentication.getPrincipal());
    }

    @Test
    void shouldReadTokenFromAuthorizationHeader() throws Exception {
        // given
        String username = "user@u";

        String token = JWT.create()
                .withSubject(username)
                .withClaim("type", "access")
                .sign(Algorithm.RSA256(null, (RSAPrivateKey) keyPair.getPrivate()));

        when(userDetailsService.loadUserByUsername(username)).thenReturn(mock(UserDetails.class));

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