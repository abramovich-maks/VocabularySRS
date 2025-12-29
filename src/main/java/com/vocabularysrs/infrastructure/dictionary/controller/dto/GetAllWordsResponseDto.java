package com.vocabularysrs.infrastructure.dictionary.controller.dto;

import java.util.List;

public record GetAllWordsResponseDto(List<WordDtoControllerResponse> dtoResponse) {
}