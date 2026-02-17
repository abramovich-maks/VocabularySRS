package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.LearningTestDto;
import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import com.vocabularysrs.domain.learningtest.dto.UserAnsweredDto;
import com.vocabularysrs.domain.learningtest.dto.QuestionDto;
import com.vocabularysrs.domain.learningtest.dto.QuestionSnapshot;

import java.util.List;

class LearningTestMapper {

    public static QuestionDto mapFromQuestionSnapshotToQuestionDto(final QuestionSnapshot question) {
        return QuestionDto.builder()
                .id(question.id())
                .wordEntryId(question.wordEntryId())
                .prompt(question.prompt())
                .direction(question.direction())
                .build();
    }

    public static UserAnsweredDto mapFromAnswerResultToAnswerResultDto(final AnswerResultDto result) {
        return UserAnsweredDto.builder().questionId(result.questionId()).wordEntryId(result.wordEntryId()).userAnswer(result.userAnswer()).correctAnswer(result.correctAnswer()).correct(result.correct()).build();
    }

    public static LearningTestDto mapFromLearningTaskToLearningTaskDto(LearningTest task) {
        List<QuestionSnapshot> questions = task.getQuestions().stream()
                .map(q -> new QuestionSnapshot(
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
