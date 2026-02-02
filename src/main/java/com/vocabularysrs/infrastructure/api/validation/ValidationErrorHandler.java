package com.vocabularysrs.infrastructure.api.validation;

import com.vocabularysrs.domain.words.InvalidWordException;
import com.vocabularysrs.domain.words.InvalidWordsGroupException;
import com.vocabularysrs.infrastructure.api.ApiErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Log4j2
public class ValidationErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorDto handleValidationExceptions(MethodArgumentNotValidException exception) {
        final List<String> errors = getErrorsFromException(exception);
        log.error(errors);
        return new ValidationErrorDto(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidWordException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleInvalidWord(InvalidWordException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(
                "WORD_VALIDATION_ERROR",
                exception.getMessage());
    }

    @ExceptionHandler(InvalidWordsGroupException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleInvalidWordsGroup(InvalidWordsGroupException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(
                "WORDS_GROUP_VALIDATION_ERROR",
                exception.getMessage());
    }

    private List<String> getErrorsFromException(final MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }
}
