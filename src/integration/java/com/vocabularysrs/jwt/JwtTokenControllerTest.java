package com.vocabularysrs.jwt;

import com.vocabularysrs.BaseIntegrationTest;
import com.vocabularysrs.domain.loginandregister.SecurityUser;
import com.vocabularysrs.infrastructure.security.jwt.vocabulary.TokenRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class JwtTokenControllerTest extends BaseIntegrationTest {

    @MockitoBean
    AuthenticationManager authenticationManager;

    @Test
    void shouldReturn200AndSetRefreshCookie() throws Exception {
        Authentication authentication = mock(Authentication.class);
        SecurityUser user = mock(SecurityUser.class);

        when(authenticationManager.authenticate(any()))
                .thenReturn(authentication);
        when(authentication.getPrincipal())
                .thenReturn(user);

        when(jwtTokenGenerator.generateAccessToken(any()))
                .thenReturn("test-access-token");
        when(jwtTokenGenerator.generateRefreshToken(any()))
                .thenReturn("test-refresh-token");

        TokenRequestDto request =
                new TokenRequestDto("email@test.com", "password");

        mockMvc.perform(post("/token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("test-access-token"))
                .andExpect(cookie().exists("refreshToken"))
                .andExpect(cookie().value("refreshToken", "test-refresh-token"))
                .andExpect(cookie().httpOnly("refreshToken", true));
    }

    @Test
    void shouldReturn401WhenAuthenticationFails() throws Exception {
        // given
        when(authenticationManager.authenticate(any()))
                .thenThrow(new BadCredentialsException("Bad credentials"));
        TokenRequestDto request = new TokenRequestDto("email@test.com", "password");
        // when & then
        mockMvc.perform(post("/token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isUnauthorized());
    }

}
