package com.vocabularysrs.infrastructure.security.jwt.vocabulary;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vocabularysrs.domain.loginandregister.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.time.Clock;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@Profile("!integration")
public class JwtTokenGenerator {

    private final Clock clock;
    private final JwtConfigurationProperties properties;
    private final KeyPair keyPair;

    public String generateAccessToken(SecurityUser user) {
        Instant issuedAt = Instant.now(clock);
        Instant expiresAt = issuedAt.plusSeconds(properties.expirationSeconds());
        Algorithm algorithm = Algorithm.RSA256(null, (RSAPrivateKey) keyPair.getPrivate());
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("userId", user.getUserId())
                .withClaim("userLanguage", user.getUserLanguage().name())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withIssuer(properties.issuer())
                .withClaim("type", "access")
                .sign(algorithm);
    }

    public String generateRefreshToken(SecurityUser user) {
        Instant issuedAt = Instant.now(clock);
        Instant expiresAt = issuedAt.plusSeconds(properties.refreshExpirationSeconds());
        Algorithm algorithm = Algorithm.RSA256(null, (RSAPrivateKey) keyPair.getPrivate());
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("userId", user.getUserId())
                .withClaim("userLanguage", user.getUserLanguage().name())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withIssuer(properties.issuer())
                .withClaim("type", "refresh")
                .sign(algorithm);
    }
}