package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DailyTestFacade {

    private final DailyTestRetriever dailyTestRetriever;
    private final DailyTestAnswerAccepter dailyTestAnswerAccepter;
    private final DailyTestResultRetriever dailyTestResultRetriever;

    public AnswerResultDto answerQuestion(Long questionId, String answer) {
        return dailyTestAnswerAccepter.answerQuestion(questionId, answer);
    }

    public DailyTestShowResponseDto retrieveDailyTest() {
        return dailyTestRetriever.retrieveDailyTest();
    }

    public DailyTestResponseDto resultTest() {
        return dailyTestResultRetriever.resultTest();
    }
}