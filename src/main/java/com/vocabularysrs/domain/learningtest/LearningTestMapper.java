package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import com.vocabularysrs.domain.learningtest.dto.LearningTestDto;
import com.vocabularysrs.domain.learningtest.dto.QuestionDto;

import java.util.List;

class LearningTestMapper {

    public static AnswerResultDto mapFromAnswerResultToAnswerResultDto(final AnswerResult result) {
        return AnswerResultDto.builder().questionId(result.questionId()).wordEntryId(result.wordEntryId()).userAnswer(result.userAnswer()).correctAnswer(result.correctAnswer()).correct(result.correct()).build();
    }

    public static LearningTestDto mapFromLearningTaskToLearningTaskDto(LearningTest task) {
        List<QuestionDto> questions = task.getQuestions().stream()
                .map(q -> new QuestionDto(
                        q.getId(),
                        q.getWordEntryId(),
                        q.getPrompt(),
                        q.getDirection(),
                        q.isAnswered()
                ))
                .toList();

        return new LearningTestDto(
                task.getId(),
                task.getTaskDate(),
                task.getUserId(),
                questions,
                task.hasUnansweredQuestions()
        );
    }
}
