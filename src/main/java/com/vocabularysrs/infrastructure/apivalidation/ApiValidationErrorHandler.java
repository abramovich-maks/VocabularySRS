package com.vocabularysrs.infrastructure.apivalidation;

import com.vocabularysrs.domain.dailytest.DailyTestAlreadyCompletedException;
import com.vocabularysrs.domain.words.WordAlreadyExistsException;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
@Log4j2
public class ApiValidationErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiValidationErrorDto handleValidationExceptions(MethodArgumentNotValidException exception) {
        final List<String> errors = getErrorsFromException(exception);
        log.error(errors);
        return new ApiValidationErrorDto(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WordAlreadyExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiValidationErrorDto handleWordAlreadyExists(WordAlreadyExistsException exception) {
        log.warn(exception.getMessage());
        return new ApiValidationErrorDto(
                List.of(exception.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(DailyTestAlreadyCompletedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiValidationErrorDto handleTestAlreadyCompleted(DailyTestAlreadyCompletedException exception) {
        log.info(exception.getMessage());
        return new ApiValidationErrorDto(
                List.of(exception.getMessage()),
                HttpStatus.NO_CONTENT
        );
    }

    private List<String> getErrorsFromException(final MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }
}
