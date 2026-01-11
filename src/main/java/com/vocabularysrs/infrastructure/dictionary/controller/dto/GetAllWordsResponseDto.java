package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import org.springframework.data.domain.Page;

public record GetAllWordsResponseDto(Page<WordDtoControllerResponse> dtoResponse) {
}