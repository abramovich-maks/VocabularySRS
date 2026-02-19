package com.vocabularysrs.infrastructure.api.notfound;

import com.vocabularysrs.domain.learningtest.LearningTestNotFoundException;
import com.vocabularysrs.domain.learningtest.QuestionNotFoundException;
import com.vocabularysrs.domain.words.WordNotFoundException;
import com.vocabularysrs.domain.words.WordsGroupNotFoundException;
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

    @ExceptionHandler(LearningTestNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleLearningTaskNotFound(LearningTestNotFoundException exception) {
        log.warn("User {} does not have a learning test for date {}.", exception.getUserId(), exception.getTaskDate());
        return new ApiErrorResponse(
                "LEARNING_TASK_NOT_FOUND",
                exception.getMessage());
    }

    @ExceptionHandler(QuestionNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleQuestionNotFound(QuestionNotFoundException exception) {
        log.warn("User {} does not have a question with id {}.", exception.getUserId(), exception.getQuestionId());
        return new ApiErrorResponse(
                "QUESTION_NOT_FOUND",
                exception.getMessage());
    }

    @ExceptionHandler(WordNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleWordNotFound(WordNotFoundException exception) {
        log.warn("Word not found. wordId={}", exception.wordId);
        return new ApiErrorResponse(
                "WORD_NOT_FOUND",
                exception.getMessage());
    }

    @ExceptionHandler(WordsGroupNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleWordsGroupNotFound(WordsGroupNotFoundException exception) {
        log.warn("Words group not found. groupId={}", exception.groupId);
        return new ApiErrorResponse(
                "WORDS_GROUP_NOT_FOUND",
                exception.getMessage());
    }
}
