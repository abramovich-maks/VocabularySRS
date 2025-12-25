package com.vocabularysrs.infrastructure.security.jwt.vocabulary;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vocabularysrs.domain.loginandregister.SecurityUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@Log4j2
@Profile("!integration")
public class JwtTokenGenerator {

    private final AuthenticationManager authenticationManager;
    private final Clock clock;
    private final JwtConfigurationProperties properties;
    private final JwtKeyPairConfig keyPair;


    public String authenticateAndGenerateToken(String username, String password) throws NoSuchAlgorithmException, IOException {
        UsernamePasswordAuthenticationToken authenticate = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticate);
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        Instant issuedAt = Instant.now(clock);
        Instant expiresAt = issuedAt.plus(Duration.ofSeconds(properties.expirationSeconds()));
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.keyPair().getPrivate();
        Algorithm algorithm = Algorithm.RSA256(null, privateKey);

        return JWT.create()
                .withSubject(securityUser.getUsername())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withIssuer(properties.issuer())
                .sign(algorithm);
    }
}