package com.vocabularysrs.infrastructure.api.integration;

import com.vocabularysrs.domain.worddetails.WordNotFoundInDictionaryException;
import com.vocabularysrs.infrastructure.api.ApiErrorResponse;
import com.vocabularysrs.infrastructure.dictionary.http.DictionaryUnavailableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class ExternalApiErrorHandler {

    @ExceptionHandler(WordNotFoundInDictionaryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleDictionaryNotFound(WordNotFoundInDictionaryException ex) {
        log.warn("DictionaryAPI error: {}", ex.getMessage());
        return new ApiErrorResponse(
                "WORD_NOT_FOUND_IN_DICTIONARY",
                ex.getMessage());
    }

    @ExceptionHandler(DictionaryUnavailableException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ApiErrorResponse handleDictionaryUnavailable(DictionaryUnavailableException ex) {
        log.warn("Dictionary API unavailable: {}", ex.getMessage());
        return new ApiErrorResponse(
                "DICTIONARY_UNAVAILABLE",
                ex.getMessage()
        );
    }

}
