package com.vocabularysrs.infrastructure.openai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class OpenAiConfig {

    @Bean("openAiWebClient")
    public WebClient openAiWebClient(WebClient.Builder builder) {
        return builder.baseUrl("https://api.openai.com")
                .build();
    }
}
