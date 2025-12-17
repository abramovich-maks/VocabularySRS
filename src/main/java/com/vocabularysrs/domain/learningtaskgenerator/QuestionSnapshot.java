package com.vocabularysrs.domain.learningtaskgenerator;

public record QuestionSnapshot(
        Long id,
        String prompt,
        TranslationDirection direction,
        String answer
) {
}
