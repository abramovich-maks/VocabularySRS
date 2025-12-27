package com.vocabularysrs.infrastructure.security.jwt.vocabulary;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "auth.jwt")
public record JwtConfigurationProperties(
        long expirationSeconds,
        String issuer,
        long refreshExpirationSeconds
) {
}