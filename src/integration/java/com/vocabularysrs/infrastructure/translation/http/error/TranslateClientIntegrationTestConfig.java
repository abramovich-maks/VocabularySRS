package com.vocabularysrs.infrastructure.translation.http.error;

import com.vocabularysrs.infrastructure.translation.http.TranslateClient;
import com.vocabularysrs.infrastructure.translation.http.TranslateClientConfigurationProperties;
import io.netty.channel.ChannelOption;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

class TranslateClientIntegrationTestConfig {

    static TranslateClient create(TranslateClientConfigurationProperties properties) {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.connectionTimeout())
                .responseTimeout(Duration.ofMillis(properties.readTimeout()));

        WebClient webClient = WebClient.builder()
                .baseUrl(properties.baseUrl())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return new TranslateClient(properties, webClient);
    }
}

