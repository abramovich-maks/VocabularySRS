package com.vocabularysrs.infrastructure.translation.http;

import com.vocabularysrs.domain.translation.TranslationAlternativeService;
import com.vocabularysrs.domain.translation.TranslationAlternatives;
import com.vocabularysrs.domain.translation.TranslationResult;
import com.vocabularysrs.domain.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.PrematureCloseException;

import java.util.List;

@RequiredArgsConstructor
public class TranslateClient implements TranslationService, TranslationAlternativeService {

    private static final String SOURCE_LANG = "en";
    private final TranslateClientConfigurationProperties properties;
    private final WebClient webClient;

    @Override
    public TranslationResult translate(String word, String targetLang) {

        TranslateResponse response = fetchTranslation(word, targetLang);

        if (response == null || response.translatedText() == null) {
            return failed(word);
        }
        return new TranslationResult(word, response.translatedText());
    }

    @Override
    public TranslationAlternatives getAlternatives(String word, String targetLang) {
        TranslateResponse response = fetchTranslation(word, targetLang);

        if (response == null || response.alternatives() == null) {
            return new TranslationAlternatives(List.of());
        }
        return new TranslationAlternatives(response.alternatives());
    }


    private TranslationResult failed(String word) {
        return new TranslationResult(word, "write your translate!");
    }

    private TranslateResponse fetchTranslation(String word, String targetLang) {
        String url = properties.baseUrl() + properties.translatePath();

        TranslateRequest request = new TranslateRequest(
                word,
                SOURCE_LANG,
                targetLang,
                "text",
                properties.sizeAlternatives()
        );

        return webClient.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        status -> status == HttpStatus.NO_CONTENT,
                        response -> Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT))
                )
                .onStatus(
                        HttpStatusCode::isError,
                        response -> WebClientResponseErrorMapper.map(response.statusCode())
                )
                .bodyToMono(TranslateResponse.class)
                .onErrorMap(
                        ex -> ex instanceof WebClientRequestException
                                || ex instanceof DecodingException
                                || ex instanceof PrematureCloseException,
                        ex -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, null, ex))
                .block();
    }
}