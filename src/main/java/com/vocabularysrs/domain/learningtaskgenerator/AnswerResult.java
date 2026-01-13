package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.Builder;

@Builder
public record AnswerResult(
        Long questionId,
        Long wordEntryId,
        String word,
        String userAnswer,
        String correctAnswer,
        boolean correct
) {
}
