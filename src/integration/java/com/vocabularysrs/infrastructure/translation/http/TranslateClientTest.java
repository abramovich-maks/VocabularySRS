package com.vocabularysrs.infrastructure.translation.http;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.vocabularysrs.domain.translation.TranslationAlternatives;
import com.vocabularysrs.domain.translation.TranslationResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;

class TranslateClientTest {

    @RegisterExtension
    static WireMockExtension wireMock = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();


    TranslateClientConfigurationProperties props =
            TranslateClientConfigurationProperties.builder()
                    .baseUrl("http://localhost:" + wireMock.getPort())
                    .translatePath("/translate")
                    .sizeAlternatives(5)
                    .connectionTimeout(1000)
                    .readTimeout(1000)
                    .build();

    TranslateClient client = new TranslateClient(props,
            WebClient.builder().build()
    );

    @Test
    void should_return_translation_and_alternatives() {
        // given
        wireMock.stubFor(post("/translate")
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                            {
                              "translatedText": "привет",
                              "alternatives": ["мама", "матерь"]
                            }
                        """)));

        // when
        TranslationResult result = client.translate("hello", "ru");
        TranslationAlternatives alternatives = client.getAlternatives("hello", "ru");

        // then
        assertThat(result.translatedText()).isEqualTo("привет");
        assertThat(alternatives.values())
                .containsExactly("мама", "матерь");
    }

    @Test
    void should_return_failed_translation_when_translated_text_is_null() {
        wireMock.stubFor(post("/translate")
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                        {
                          "alternatives": ["мама"]
                        }
                    """)));

        TranslationResult result = client.translate("hello", "ru");

        assertThat(result.translatedText()).isEqualTo("write your translate!");
    }

}
