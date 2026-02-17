package com.vocabularysrs.domain.learningtest;


import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtest.dto.DailyTestDto;
import com.vocabularysrs.domain.learningtest.dto.UserAnsweredDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LearningTestFacade {

    private final DailyTestRetriever dailyTestRetriever;
    private final DailyTestResultRetriever dailyTestResultRetriever;
    private final DailyTestAnswerAccepter dailyTestAnswerAccepter;

    public UserAnsweredDto answerTheQuestion(Long questionId, String answer) {
        return dailyTestAnswerAccepter.answerQuestion(questionId, answer);
    }

    public DailyTestDto getDailyTets() {
        return dailyTestRetriever.retrieveDailyTest();
    }

    public DailyTestResponseDto showTestResults() {
        return dailyTestResultRetriever.resultTest();
    }
}
