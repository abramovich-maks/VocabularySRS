package com.vocabularysrs.infrastructure.dictionary.dto;

import java.util.List;

public record GetAllWordsResponseDto(List<WordDtoControllerResponse> dtoResponse) {
}