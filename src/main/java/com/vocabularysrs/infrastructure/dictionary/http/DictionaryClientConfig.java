package com.vocabularysrs.infrastructure.dictionary.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vocabularysrs.domain.worddetails.WordDetailsFetchable;
import lombok.AllArgsConstructor;
import org.springframework.boot.http.client.ClientHttpRequestFactorySettings;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;


@Configuration
@AllArgsConstructor
public class DictionaryClientConfig {

    private final DictionaryRestTemplateConfigurationProperties properties;

    @Bean
    public RestTemplate restTemplate() {
        ClientHttpRequestFactorySettings settings = ClientHttpRequestFactorySettings.defaults()
                .withConnectTimeout(Duration.ofMillis(properties.connectionTimeout()))
                .withReadTimeout(Duration.ofMillis(properties.readTimeout()));
        return new RestTemplateBuilder()
                .requestFactorySettings(settings)
                .build();
    }

    @Bean
    public WordDetailsFetchable httpWordDetails(RestTemplate restTemplate, ObjectMapper objectMapper) {
        return new WordDetailsRestTemplate(restTemplate, objectMapper, properties.uri());
    }
}