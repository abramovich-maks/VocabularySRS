package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskResultPort;

import java.time.LocalDate;
import java.util.List;

class LearningTaskResultPortTestImpl implements LearningTaskResultPort {
    @Override
    public List<AnswerResult> getResultsForTask(LocalDate date, Long userId) {
        return List.of(
                AnswerResult.builder()
                        .questionId(1L)
                        .wordEntryId(1L)
                        .userAnswer("cat")
                        .correctAnswer("cat")
                        .correct(false)
                        .build(),
                AnswerResult.builder()
                        .questionId(2L)
                        .wordEntryId(2L)
                        .userAnswer("dog")
                        .correctAnswer("dog")
                        .correct(false)
                        .build(),
                AnswerResult.builder()
                        .questionId(3L)
                        .wordEntryId(3L)
                        .userAnswer("sun")
                        .correctAnswer("солнце")
                        .correct(true)
                        .build()
        );
    }
}