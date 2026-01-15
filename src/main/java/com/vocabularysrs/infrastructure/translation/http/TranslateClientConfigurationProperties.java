package com.vocabularysrs.infrastructure.translation.http;

import lombok.Builder;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Builder
@ConfigurationProperties(prefix = "translate.http.client.config")
public record TranslateClientConfigurationProperties(
        int connectionTimeout,
        int readTimeout,
        String baseUrl,
        String translatePath,
        int sizeAlternatives
) {
}