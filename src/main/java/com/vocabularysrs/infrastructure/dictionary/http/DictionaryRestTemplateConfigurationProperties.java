package com.vocabularysrs.infrastructure.dictionary.http;

import lombok.Builder;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dictionary.http.client.config")
@Builder
public record DictionaryRestTemplateConfigurationProperties(long connectionTimeout, long readTimeout, String uri) {
}
