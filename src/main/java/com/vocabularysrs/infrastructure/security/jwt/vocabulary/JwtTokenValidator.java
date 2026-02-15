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
import java.time.Clock;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class JwtTokenValidator {

    private final KeyPair keyPair;
    private final Clock clock;

    public DecodedJWT verifyRefreshToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), null)).build();
        DecodedJWT jwt = verifier.verify(token);
        if (!"refresh".equals(jwt.getClaim("type").asString())) {
            throw new JWTVerificationException("Not a refresh token");
        }
        return jwt;
    }

    public DecodedJWT verifyAccessToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), null);
        algorithm.verify(jwt);
        Instant now = Instant.now(clock);
        Instant expiresAt = jwt.getExpiresAt().toInstant();

        if (expiresAt.isBefore(now)) {
            throw new JWTVerificationException("Token expired");
        }
        if (!"access".equals(jwt.getClaim("type").asString())) {
            throw new JWTVerificationException("Not an access token");
        }
        return jwt;
    }
}