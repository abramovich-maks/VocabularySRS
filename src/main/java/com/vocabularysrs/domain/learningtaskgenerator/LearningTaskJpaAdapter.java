//package com.vocabularysrs.domain.learningtaskgenerator;
//
//import com.vocabularysrs.domain.learningtest.LearningTask;
//import com.vocabularysrs.domain.learningtest.LearningTaskRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//
//@AllArgsConstructor
//@Component
//class LearningTaskJpaAdapter implements LearningTaskReadPort {
//
//    private final LearningTaskRepository learningTaskRepository;
//
//    @Override
//    public LearningTestDto findLearningTaskByDateAndUserId(final LocalDate taskDate, final Long userId) {
//        LearningTask task = learningTaskRepository.findLearningTaskByTaskDateAndUserId(taskDate, userId)
//                .orElseThrow(() -> new LearningTestNotFoundException(taskDate, userId));
//        return LearningTaskMapper.mapFromLearningTaskToLearningTaskDto(task);
//    }
//
//}