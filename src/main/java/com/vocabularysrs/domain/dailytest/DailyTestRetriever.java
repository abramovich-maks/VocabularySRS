package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.DailyTestShowRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
import com.vocabularysrs.domain.dailytest.dto.QuestionDto;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskSnapshot;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class DailyTestRetriever {

    private final LearningTaskReadPort learningTaskReadPort;


    public DailyTestShowResponseDto retrieveDailyTest(DailyTestShowRequestDto requestDto) {
        LearningTaskSnapshot questions = learningTaskReadPort.findLearningTaskByDateAndUserId(requestDto.date(), requestDto.userId());
        return DailyTestShowResponseDto.builder()
                .id(questions.id())
                .userId(questions.userId())
                .taskDate(questions.taskDate())
                .questions(questions.questions().stream().map(question -> QuestionDto.builder()
                        .id(question.id())
                        .wordEntryId(question.wordEntryId())
                        .prompt(question.prompt())
                        .direction(question.direction())
                        .answer(question.answer())
                        .build()).toList())
                .build();
    }
}
