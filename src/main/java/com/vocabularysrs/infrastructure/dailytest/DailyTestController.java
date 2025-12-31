package com.vocabularysrs.infrastructure.dailytest;

import com.vocabularysrs.domain.dailytest.DailyTestFacade;
import com.vocabularysrs.domain.dailytest.dto.DailyTestRequestDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dailytest")
@AllArgsConstructor
class DailyTestController {

    private final DailyTestFacade dailyTestFacade;

    @PostMapping
    public ResponseEntity<DailyTestControllerResponseDto> processDailyTest(@Valid @RequestBody DailyTestControllerRequestDto request) {
        DailyTestRequestDto dailyTestRequestDto = new DailyTestRequestDto(request.answers());
        DailyTestResponseDto response = dailyTestFacade.processDailyTest(dailyTestRequestDto);
        DailyTestControllerResponseDto responseDto = new DailyTestControllerResponseDto(response.userId(), response.total(), response.correct(), response.incorrect(), response.answers());
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<DailyTestShowResponseDto> retrieveDailyTest() {
        DailyTestShowResponseDto dailyTestShowResponseDto = dailyTestFacade.retrieveDailyTest();
        return ResponseEntity.ok(dailyTestShowResponseDto);
    }
}