package com.vocabularysrs.infrastructure.dictionary.http;

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
    public RestTemplateResponseErrorHandler restTemplateResponseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        ClientHttpRequestFactorySettings settings = ClientHttpRequestFactorySettings.defaults()
                .withConnectTimeout(Duration.ofMillis(properties.connectionTimeout()))
                .withReadTimeout(Duration.ofMillis(properties.readTimeout()));
        return new RestTemplateBuilder()
                .errorHandler(restTemplateResponseErrorHandler)
                .requestFactorySettings(settings)
                .build();
    }


    @Bean
    public WordDetailsFetchable httpWordDetails(RestTemplate restTemplate) {
        return new WordDetailsRestTemplate(restTemplate, properties.uri());
    }
}