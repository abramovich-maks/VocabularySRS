package com.vocabularysrs.infrastructure.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vocabularysrs.domain.openai.ExampleGenerationService;
import com.vocabularysrs.infrastructure.openai.request.ContentRequest;
import com.vocabularysrs.infrastructure.openai.request.InputRequest;
import com.vocabularysrs.infrastructure.openai.request.OpenAiRequest;
import com.vocabularysrs.infrastructure.openai.request.ReasoningRequest;
import com.vocabularysrs.infrastructure.openai.response.ExamplesWrapper;
import com.vocabularysrs.infrastructure.openai.response.OpenAiResponse;
import com.vocabularysrs.infrastructure.translation.http.WebClientResponseErrorMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.PrematureCloseException;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;

@Log4j2
@Service
class OpenAiExampleGenerationService implements ExampleGenerationService {

    private final OpenAiConfigurationProperties properties;
    @Qualifier("openAiWebClient")
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    private static final String PROMPT_TEMPLATE = """
            Target word: "%s"
            
            Generate 3 natural B1-B2 sentences.
            The word must appear naturally.
            Focus on human actions or experiences.
            Do not start sentences with the target word.
            Each sentence MUST contain the exact word "%s".
            Max 15 words.
            
            Return JSON:
            {"examples":["...","...","..."]}
            """;

    OpenAiExampleGenerationService(final OpenAiConfigurationProperties properties, @Qualifier("openAiWebClient") final WebClient webClient, final ObjectMapper objectMapper) {
        this.properties = properties;
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<String> generateExamples(final String word) {
        OpenAiRequest openAiRequest = getOpenAiRequest(word);

        OpenAiResponse response = webClient.post()
                .uri(properties.url())
                .header("Authorization", "Bearer " + properties.apiKey())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(openAiRequest)
                .retrieve()
                .onStatus(
                        status -> status == HttpStatus.NO_CONTENT,
                        clientResponse -> Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT))
                )
                .onStatus(
                        HttpStatusCode::isError,
                        clientResponse -> WebClientResponseErrorMapper.map(clientResponse.statusCode())
                )
                .bodyToMono(OpenAiResponse.class)
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1))
                        .filter(throwable -> throwable instanceof WebClientRequestException))
                .onErrorMap(
                        ex -> ex instanceof WebClientRequestException
                                || ex instanceof DecodingException
                                || ex instanceof PrematureCloseException
                                || reactor.core.Exceptions.isRetryExhausted(ex),
                        ex -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, null, ex))
                .block();

        return response != null ? getExamples(response, word) : List.of();
    }

    private OpenAiRequest getOpenAiRequest(final String word) {
        String prompt = PROMPT_TEMPLATE.formatted(word, word);
        ContentRequest content = new ContentRequest("input_text", prompt);
        InputRequest inputRequest = new InputRequest("user", List.of(content));
        ReasoningRequest reasoningRequest = new ReasoningRequest("minimal");

        return new OpenAiRequest(
                properties.model(),
                List.of(inputRequest),
                reasoningRequest,
                false
        );
    }

    private List<String> getExamples(OpenAiResponse response, String word) {
        log.info("Successfully generated examples for word '{}'. Tokens used: {}", word, response.usage().total_tokens());
        return response.output().stream()
                .filter(o -> "message".equals(o.type()))
                .findFirst()
                .map(o -> o.content().get(0).text())
                .map(this::parseExamplesList)
                .orElse(List.of());
    }

    private List<String> parseExamplesList(String jsonText) {
        try {
            ExamplesWrapper wrapper = objectMapper.readValue(jsonText, ExamplesWrapper.class);
            return wrapper.examples();
        } catch (JsonProcessingException e) {
            log.error("Failed to parse OpenAI inner JSON: {}", jsonText, e);
            return List.of();
        }
    }
}
