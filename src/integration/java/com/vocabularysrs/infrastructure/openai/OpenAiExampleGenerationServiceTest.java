package com.vocabularysrs.infrastructure.openai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertEquals;

class OpenAiExampleGenerationServiceTest {

    @RegisterExtension
    static WireMockExtension wireMock = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();

    @Test
    void should_generate_examples_from_openai_response() {

        wireMock.stubFor(post(urlEqualTo("/v1/responses"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                  "output":[
                                    {
                                      "type":"message",
                                      "content":[
                                        {
                                          "text":"{\\"examples\\":[\\"one\\",\\"two\\",\\"three\\"]}"
                                        }
                                      ]
                                    }
                                  ],
                                  "usage":{"total_tokens":52}
                                }
                                """)));

        OpenAiConfigurationProperties props =
                OpenAiConfigurationProperties.builder()
                        .url("http://localhost:" + wireMock.getPort() + "/v1/responses")
                        .apiKey("test")
                        .build();

        OpenAiExampleGenerationService client =
                new OpenAiExampleGenerationService(
                        props,
                        WebClient.builder().build(),
                        new ObjectMapper());

        List<String> result = client.generateExamples("cat");

        assertEquals(List.of("one", "two", "three"), result);
    }
}