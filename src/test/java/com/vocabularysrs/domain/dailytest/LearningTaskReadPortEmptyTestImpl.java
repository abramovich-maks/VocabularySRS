package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskDto;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.QuestionSnapshot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class LearningTaskReadPortEmptyTestImpl implements LearningTaskReadPort {
    @Override
    public LearningTaskDto findLearningTaskByDateAndUserId(final LocalDate today, final Long userId) {
        List<QuestionSnapshot> question = new ArrayList<>();

        QuestionSnapshot cat = new QuestionSnapshot(1L, 1L, "cat", null, true);
        QuestionSnapshot dog = new QuestionSnapshot(2L, 2L, "dog", null, true);
        QuestionSnapshot sun = new QuestionSnapshot(3L, 3L, "солнце", null, true);

        question.add(cat);
        question.add(dog);
        question.add(sun);

        return new LearningTaskDto(1L, today, userId, question, true);
    }

    @Override
    public Optional<LearningTaskDto> findInProgress(LocalDate date, Long userId) {
        return Optional.of(findLearningTaskByDateAndUserId(date, userId));
    }
}