package com.vocabularysrs.infrastructure.openai;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

class OpenAiConfig {

    @Bean
    public WebClient openAiWebClient(WebClient.Builder builder) {
        return builder.baseUrl("https://api.openai.com")
                .build();
    }
}
