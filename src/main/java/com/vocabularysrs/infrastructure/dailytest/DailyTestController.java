package com.vocabularysrs.infrastructure.dailytest;

import com.vocabularysrs.domain.learningtest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.learningtest.LearningTestFacade;
import com.vocabularysrs.domain.learningtest.dto.DailyTestDto;
import com.vocabularysrs.domain.learningtest.dto.UserAnsweredDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dailytest")
@AllArgsConstructor
class DailyTestController {

    private final LearningTestFacade learningTestFacade;

    @PostMapping("/questions/{questionId}/answer")
    public ResponseEntity<UserAnsweredDto> answerQuestion(@PathVariable Long questionId, @Valid @RequestBody AnswerQuestionRequestDto request) {
        UserAnsweredDto result = learningTestFacade.answerTheQuestion(questionId, request.userAnswer());
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<DailyTestDto> retrieveDailyTest() {
        DailyTestDto dailyTestDto = learningTestFacade.getDailyTets();
        return ResponseEntity.ok(dailyTestDto);
    }

    @PostMapping("/result")
    public ResponseEntity<DailyTestResponseDto> result() {
        return ResponseEntity.ok(learningTestFacade.showTestResults());
    }
}