package com.vocabularysrs.infrastructure.api.business;

import com.vocabularysrs.domain.loginandregister.UserAlreadyExistException;
import com.vocabularysrs.domain.words.WordAlreadyExistsException;
import com.vocabularysrs.domain.words.WordsGroupAlreadyExistsException;
import com.vocabularysrs.infrastructure.api.ApiErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Log4j2
public class BusinessErrorHandler {


    @ExceptionHandler(WordAlreadyExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiErrorResponse handleWordAlreadyExists(WordAlreadyExistsException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(
                "WORD_ALREADY_EXIST",
                exception.getMessage());
    }

    @ExceptionHandler(WordsGroupAlreadyExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiErrorResponse handleWordsGroupAlreadyExists(WordsGroupAlreadyExistsException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(
                "WORDS_GROUP_ALREADY_EXIST",
                exception.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiErrorResponse handleUserAlreadyExists(UserAlreadyExistException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(
                "USER_ALREADY_EXIST",
                exception.getMessage());
    }
}