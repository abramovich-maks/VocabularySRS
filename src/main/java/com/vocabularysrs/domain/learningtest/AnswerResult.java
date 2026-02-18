package com.vocabularysrs.domain.learningtest;

record AnswerResult(
        Long questionId,
        Long wordEntryId,
        String word,
        String userAnswer,
        String correctAnswer,
        boolean correct
) {
}

