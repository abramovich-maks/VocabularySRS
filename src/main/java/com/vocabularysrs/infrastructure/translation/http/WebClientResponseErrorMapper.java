package com.vocabularysrs.infrastructure.translation.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

class WebClientResponseErrorMapper {

    static Mono<? extends Throwable> map(HttpStatusCode status) {
        if (status.is5xxServerError()) {
            return Mono.error(new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error while using http client"
            ));
        }

        if (status.is4xxClientError()) {
            if (status.value() == 404) {
                return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND));
            }
            if (status.value() == 401) {
                return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED));
            }
        }

        return Mono.empty();
    }
}
