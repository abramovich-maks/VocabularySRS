package com.vocabularysrs.domain.learningtaskgenerator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
class LearningTaskJpaAdapter implements LearningTaskReadPort, LearningTaskWritePort, LearningTaskResultPort {

    private final LearningTaskRepository learningTaskRepository;
    private final Clock clock;

    @Override
    public LearningTaskDto findLearningTaskByDateAndUserId(final LocalDate taskDate, final Long userId) {
        LearningTask task = learningTaskRepository.findLearningTaskByTaskDateAndUserId(taskDate, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(taskDate, userId));
        return LearningTaskMapper.mapFromLearningTaskToLearningTaskDto(task);
    }

    @Override
    public Optional<LearningTaskDto> findInProgress(LocalDate date, Long userId) {
        return learningTaskRepository.findLearningTaskByTaskDateAndUserId(date, userId)
                .map(LearningTaskMapper::mapFromLearningTaskToLearningTaskDto);
    }

    @Override
    public AnswerResult answerQuestion(Long userId, Long questionId, String userAnswer) {
        LearningTask task = learningTaskRepository
                .findByQuestionIdAndUserId(questionId, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(LocalDate.now(clock), userId));

        AnswerResult result = task.answerQuestion(questionId, userAnswer);

        learningTaskRepository.save(task);

        return result;
    }

    @Override
    public List<AnswerResult> getResultsForTask(LocalDate date, Long userId) {
        LearningTask task = learningTaskRepository
                .findLearningTaskByTaskDateAndUserId(date, userId)
                .orElseThrow(() -> new LearningTaskNotFoundException(date, userId));

        return task.getQuestions().stream()
                .filter(Question::isAnswered)
                .map(Question::toResult)
                .toList();
    }
}