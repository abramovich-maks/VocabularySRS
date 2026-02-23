package com.vocabularysrs.infrastructure.openai;

import lombok.Builder;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Builder
@ConfigurationProperties(prefix = "openai.client.config")
public record OpenAiConfigurationProperties(
        String apiKey,
        String model,
        String url
) {
}
