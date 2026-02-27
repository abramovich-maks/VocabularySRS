package com.vocabularysrs.infrastructure.openai;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.web.server.ResponseStatusException;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class OpenApiErrorsIntegrationTest {

    @RegisterExtension
    static WireMockExtension wireMock = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();


    OpenAiConfigurationProperties props =
            OpenAiConfigurationProperties.builder()
                    .url("http://localhost:" + wireMock.getPort() + "/v1/responses")
                    .apiKey("test")
                    .connectionTimeout(1000)
                    .readTimeout(1000)
                    .build();

    OpenAiExampleGenerationService client = OpenApiIntegrationTestConfig.create(props);


    @Test
    void should_throw_exception_500_when_fault_connection_reset_by_peer() {
        // given
        wireMock.stubFor(WireMock.post("/v1/responses")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withFault(Fault.CONNECTION_RESET_BY_PEER)));
        // when
        Throwable throwable = Assertions.catchThrowable(() -> client.generateExamples("cat"));
        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("500 INTERNAL_SERVER_ERROR");
    }


    @Test
    void should_throw_exception_500_when_fault_empty_response() {
        // given
        wireMock.stubFor(WireMock.post("/v1/responses")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withFault(Fault.EMPTY_RESPONSE)));
        // when
        Throwable throwable = catchThrowable(() -> client.generateExamples("cat"));
        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("500 INTERNAL_SERVER_ERROR");
    }

    @Test
    void should_throw_exception_500_when_fault_random_data_then_close() {
        // given
        wireMock.stubFor(WireMock.post("/v1/responses")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withFault(Fault.RANDOM_DATA_THEN_CLOSE)));
        // when
        Throwable throwable = catchThrowable(() -> client.generateExamples("cat"));
        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("500 INTERNAL_SERVER_ERROR");
    }

    @Test
    void should_throw_exception_204_when_status_is_204_no_content() {
        // given
        wireMock.stubFor(WireMock.post("/v1/responses")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_NO_CONTENT)
                ));
        // when
        Throwable throwable = catchThrowable(() -> client.generateExamples("cat"));
        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("204 NO_CONTENT");
    }

    @Test
    void should_throw_exception_500_when_response_delay_is_5000_ms_and_client_has_1000ms_read_timeout() {
        // given
        wireMock.stubFor(WireMock.post("/v1/responses")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withFixedDelay(5000)));
        // when
        Throwable throwable = catchThrowable(() -> client.generateExamples("cat"));
        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("500 INTERNAL_SERVER_ERROR");
    }

    @Test
    void should_throw_exception_404_when_http_service_returning_not_found_status() {
        // given
        wireMock.stubFor(WireMock.post("/v1/responses")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_NOT_FOUND))
        );
        // when
        Throwable throwable = catchThrowable(() -> client.generateExamples("cat"));
        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("404 NOT_FOUND");
    }

    @Test
    void should_throw_exception_401_when_http_service_returning_unauthorized_status() {
        // given
        wireMock.stubFor(WireMock.post("/v1/responses")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_UNAUTHORIZED))
        );
        // when
        Throwable throwable = catchThrowable(() -> client.generateExamples("cat"));
        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("401 UNAUTHORIZED");
    }
}
