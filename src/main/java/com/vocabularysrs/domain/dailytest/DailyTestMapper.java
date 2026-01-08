package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.dailytest.dto.QuestionDto;
import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import com.vocabularysrs.domain.learningtaskgenerator.QuestionSnapshot;

class DailyTestMapper {

    public static QuestionDto mapFromQuestionSnapshotToQuestionDto(final QuestionSnapshot question) {
        return QuestionDto.builder()
                .id(question.id())
                .wordEntryId(question.wordEntryId())
                .prompt(question.prompt())
                .direction(question.direction())
                .build();
    }

    public static AnswerResultDto mapFromAnswerResultToAnswerResultDto(final AnswerResult result) {
        return AnswerResultDto.builder().questionId(result.questionId()).wordEntryId(result.wordEntryId()).userAnswer(result.userAnswer()).correctAnswer(result.correctAnswer()).correct(result.correct()).build();
    }
}
