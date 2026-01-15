package com.vocabularysrs.infrastructure.api.notfound;

import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskNotFoundException;
import com.vocabularysrs.domain.words.WordNotFoundException;
import com.vocabularysrs.infrastructure.api.ApiErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
class NotFoundErrorHandler {

    @ExceptionHandler(LearningTaskNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleLearningTaskNotFound(LearningTaskNotFoundException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(
                "LEARNING_TASK_NOT_FOUND",
                exception.getMessage());
    }

    @ExceptionHandler(WordNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleWordNotFound(WordNotFoundException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(
                "WORD_NOT_FOUND",
                exception.getMessage());
    }
}
