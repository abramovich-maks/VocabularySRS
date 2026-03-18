package com.vocabularysrs.infrastructure.openai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vocabularysrs.infrastructure.translation.http.TranslateClient;
import com.vocabularysrs.infrastructure.translation.http.TranslateClientConfigurationProperties;
import io.netty.channel.ChannelOption;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

class OpenApiIntegrationTestConfig {

    static OpenAiExampleGenerationService create(OpenAiConfigurationProperties properties) {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.connectionTimeout())
                .responseTimeout(Duration.ofMillis(properties.readTimeout()));

        WebClient webClient = WebClient.builder()
                .baseUrl(properties.url())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return new OpenAiExampleGenerationService(properties, webClient,new ObjectMapper());
    }
}

