package com.vocabularysrs.infrastructure.translation.http;

import com.vocabularysrs.domain.translation.TranslationResult;
import com.vocabularysrs.domain.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RequiredArgsConstructor
class TranslateClient implements TranslationService {

    private static final String SOURCE_LANG = "en";
    private final TranslateClientConfigurationProperties properties;
    private final WebClient webClient;

    @Override
    public TranslationResult translate(String word, String targetLang) {

        TranslateRequest request = new TranslateRequest(
                word,
                SOURCE_LANG,
                targetLang,
                "text",
                properties.sizeAlternatives()
        );

        TranslateResponse response;

        response = webClient.post()
                .uri(properties.translatePath())
                .contentType(MediaType.APPLICATION_JSON)
                .header("User-Agent", "VocabularySRS/1.0")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(TranslateResponse.class)
                .block();

        if (response == null || response.translatedText() == null) {
            return failed(word);
        }
        List<String> alternative = response.alternatives().stream().toList();
        return new TranslationResult(
                word,
                response.translatedText(), alternative);
    }

    private TranslationResult failed(String word) {
        return new TranslationResult(
                word,
                "write your translate!",
                List.of()
        );
    }
}