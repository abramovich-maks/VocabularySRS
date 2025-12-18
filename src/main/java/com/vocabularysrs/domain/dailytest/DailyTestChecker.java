package com.vocabularysrs.domain.dailytest;

import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.UserAnswerRequestDto;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskSnapshot;
import com.vocabularysrs.domain.learningtaskgenerator.QuestionSnapshot;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
class DailyTestChecker {

    private final LearningTaskReadPort learningTaskReadPort;

    public DailyTestResponseDto checkResult(DailyTestRequestDto request) {
        LearningTaskSnapshot task = learningTaskReadPort.findLearningTaskByDateAndUserId(request.date(), request.userId());

        Map<Long, QuestionSnapshot> questionsById = task.questions()
                .stream()
                .collect(Collectors.toMap(QuestionSnapshot::id, question -> question));

        int correct = 0;
        int incorrect = 0;
        List<AnswerResultDto> results = new ArrayList<>();

        for (UserAnswerRequestDto userAnswerRequestDto : request.answers()) {
            QuestionSnapshot question = questionsById.get(userAnswerRequestDto.questionId());

            boolean isCorrect = question.answer().equalsIgnoreCase(userAnswerRequestDto.answer().trim());

            if (isCorrect) correct++;
            else incorrect++;

            results.add(AnswerResultDto.builder()
                    .questionId(question.id())
                    .userAnswer(userAnswerRequestDto.answer())
                    .correctAnswer(question.answer())
                    .correct(isCorrect)
                    .build());
        }

        return DailyTestResponseDto.builder()
                .userId(request.userId())
                .total(task.questions().size())
                .correct(correct)
                .incorrect(incorrect)
                .answers(results)
                .build();
    }
}
