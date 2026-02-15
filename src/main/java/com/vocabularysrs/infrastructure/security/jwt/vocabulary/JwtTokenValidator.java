package com.vocabularysrs.infrastructure.security.jwt.vocabulary;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
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
    private final JwtConfigurationProperties properties;

    public DecodedJWT verifyAccessToken(String token) {
        return verify(token, "access");
    }

    public DecodedJWT verifyRefreshToken(String token) {
        return verify(token, "refresh");
    }

    private DecodedJWT verify(String token, String expectedType) {

        DecodedJWT jwt = JWT.decode(token);

        verifySignature(jwt);
        verifyIssuer(jwt);
        verifyExpiration(jwt);
        verifyLanguage(jwt);
        verifyType(jwt, expectedType);

        return jwt;
    }

    private void verifySignature(DecodedJWT jwt) {
        Algorithm algorithm =
                Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), null);
        algorithm.verify(jwt);
    }

    private void verifyIssuer(DecodedJWT jwt) {
        if (!properties.issuer().equals(jwt.getIssuer())) {
            throw new JWTVerificationException("Invalid issuer");
        }
    }

    private void verifyExpiration(DecodedJWT jwt) {
        if (jwt.getExpiresAt() == null) {
            throw new JWTVerificationException("Missing expiration");
        }

        Instant now = Instant.now(clock);
        if (jwt.getExpiresAt().toInstant().isBefore(now)) {
            throw new JWTVerificationException("Token expired");
        }
    }

    private void verifyLanguage(DecodedJWT jwt) {
        if (jwt.getClaim("language").isNull()) {
            throw new JWTVerificationException("Missing language claim");
        }
    }

    private void verifyType(DecodedJWT jwt, String expectedType) {
        if (!expectedType.equals(jwt.getClaim("type").asString())) {
            throw new JWTVerificationException("Invalid token type");
        }
    }
}