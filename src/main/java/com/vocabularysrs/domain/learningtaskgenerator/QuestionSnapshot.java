package com.vocabularysrs.domain.learningtaskgenerator;

public record QuestionSnapshot(
        Long id,
        Long wordEntryId,
        String prompt,
        TranslationDirection direction,
        boolean answered
) {
}
