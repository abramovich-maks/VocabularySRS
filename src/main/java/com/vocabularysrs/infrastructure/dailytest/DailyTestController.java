package com.vocabularysrs.infrastructure.dailytest;

import com.vocabularysrs.domain.dailytest.DailyTestFacade;
import com.vocabularysrs.domain.dailytest.dto.AnswerResultDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
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

    private final DailyTestFacade dailyTestFacade;

    @PostMapping("/questions/{questionId}/answer")
    public ResponseEntity<AnswerResultDto> answerQuestion(@PathVariable Long questionId, @Valid @RequestBody AnswerQuestionRequestDto request) {
        AnswerResultDto result = dailyTestFacade.answerQuestion(questionId, request.userAnswer());
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<DailyTestShowResponseDto> retrieveDailyTest() {
        DailyTestShowResponseDto dailyTestShowResponseDto = dailyTestFacade.retrieveDailyTest();
        return ResponseEntity.ok(dailyTestShowResponseDto);
    }

    @PostMapping("/result")
    public ResponseEntity<DailyTestResponseDto> result() {
        return ResponseEntity.ok(dailyTestFacade.resultTest());
    }
}