package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

@Component
@RequiredArgsConstructor
public class JwtTokenValidator {

    private final KeyPair keyPair;

    public DecodedJWT verifyRefreshToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), null)).build();
        DecodedJWT jwt = verifier.verify(token);
        if (!"refresh".equals(jwt.getClaim("type").asString())) {
            throw new JWTVerificationException("Not a refresh token");
        }
        return jwt;
    }
}