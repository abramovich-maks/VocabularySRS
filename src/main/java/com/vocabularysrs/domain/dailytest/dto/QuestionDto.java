package com.vocabularysrs.domain.dailytest.dto;

import com.vocabularysrs.domain.learningtaskgenerator.TranslationDirection;
import lombok.Builder;

@Builder
public record QuestionDto(
        Long id,
        Long wordEntryId,
        String prompt,
        TranslationDirection direction,
        String answer) {
}