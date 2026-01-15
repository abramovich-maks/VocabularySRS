package com.vocabularysrs.infrastructure.translation.http;

import com.vocabularysrs.domain.translation.TranslationAlternativeService;
import com.vocabularysrs.domain.translation.TranslationService;
import io.netty.channel.ChannelOption;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@AllArgsConstructor
@Configuration
public class TranslateClientConfig {

    private final TranslateClientConfigurationProperties properties;

    @Bean
    WebClient translateWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.connectionTimeout())
                .responseTimeout(Duration.ofMillis(properties.readTimeout()));
        return WebClient.builder()
                .baseUrl(properties.baseUrl())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean
    TranslationService translationService() {
        return new TranslateClient(properties, translateWebClient());
    }

    @Bean
    TranslationAlternativeService translationAlternativeService(){
        return new TranslateClient(properties,translateWebClient());
    }
}
