package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskSnapshot;
import com.vocabularysrs.domain.learningtaskgenerator.QuestionSnapshot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.vocabularysrs.domain.learningtaskgenerator.LearningTaskStatus.PENDING;

class LearningTaskReadPortTestImpl implements LearningTaskReadPort {
    @Override
    public LearningTaskSnapshot findLearningTaskByDateAndUserId(final LocalDate today, final Long userId) {
        List<QuestionSnapshot> question = new ArrayList<>();

        QuestionSnapshot cat = new QuestionSnapshot(1L, 1L, "cat", null, "кот");
        QuestionSnapshot dog = new QuestionSnapshot(2L, 2L, "dog", null, "собака");
        QuestionSnapshot sun = new QuestionSnapshot(3L, 3L, "солнце", null, "sun");

        question.add(cat);
        question.add(dog);
        question.add(sun);

        return new LearningTaskSnapshot(1L, today, userId, question, PENDING);
    }

    @Override
    public boolean existsFor(final Long userId, final LocalDate date) {
        return userId != null && date != null;
    }
}