package com.vocabularysrs.domain.learningtest.dto;

import java.time.LocalDate;
import java.util.List;

public record LearningTestDto(
        Long id,
        LocalDate taskDate,
        Long userId,
        List<QuestionSnapshot> questions,
        boolean hasUnansweredQuestions
) {
}
