package com.vocabularysrs.domain.learningtest;

import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import com.vocabularysrs.domain.loginandregister.User;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import lombok.AllArgsConstructor;

import static com.vocabularysrs.domain.learningtest.LearningTestMapper.mapFromAnswerResultToAnswerResultDto;

@AllArgsConstructor
class DailyTestAnswerAccepter {

    private final CurrentUserProvider currentUserProvider;
    private final LearningTestRepository learningTestRepository;
    private final UserReadPort userReadPort;

    public AnswerResultDto answerQuestion(Long questionId, String userAnswer) {
        Long userId = currentUserProvider.getCurrentUserId();
        User user = userReadPort.getReferenceById(userId);
        LearningTest test = learningTestRepository.findByQuestionIdAndUser(questionId, user)
                .orElseThrow(() -> new QuestionNotFoundException(questionId, userId));
        AnswerResult result = test.answerQuestion(questionId, userAnswer);
        learningTestRepository.save(test);
        return mapFromAnswerResultToAnswerResultDto(result);
    }
}