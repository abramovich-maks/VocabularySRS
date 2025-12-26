package com.vocabularysrs.jwt;

import com.vocabularysrs.BaseIntegrationTest;
import com.vocabularysrs.infrastructure.security.jwt.vocabulary.TokenRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class JwtTokenControllerTest extends BaseIntegrationTest {


    @Test
    void shouldReturn200AndSetCookie() throws Exception {
        // given
        when(jwtTokenGenerator.authenticateAndGenerateToken(any(), any()))
                .thenReturn("test-token");
        String token = "test-token";

        TokenRequestDto request = new TokenRequestDto("email@test.com", "password");

        // when & then
        mockMvc.perform(post("/token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(token))
                .andExpect(cookie().exists("accessToken"))
                .andExpect(cookie().value("accessToken", token))
                .andExpect(cookie().httpOnly("accessToken", true))
                .andExpect(cookie().secure("accessToken", true));
    }

    @Test
    void shouldReturn401WhenAuthenticationFails() throws Exception {
        // given
        when(jwtTokenGenerator.authenticateAndGenerateToken(any(), any()))
                .thenThrow(new BadCredentialsException("Bad credentials"));
        TokenRequestDto request = new TokenRequestDto("email@test.com", "password");
        // when & then
        mockMvc.perform(post("/token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isUnauthorized());
    }

}

