package com.vocabularysrs.infrastructure.openai;

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
class OpenAiConfig {

    private final OpenAiConfigurationProperties properties;

    @Bean("openAiWebClient")
    public WebClient openAiWebClient(WebClient.Builder builder) {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.connectionTimeout())
                .responseTimeout(Duration.ofMillis(properties.readTimeout()));
        return builder.baseUrl("https://api.openai.com")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
