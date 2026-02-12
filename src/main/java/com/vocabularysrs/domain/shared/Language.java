package com.vocabularysrs.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    RU("ru"),
    PL("pl"),
    DE("de");

    private final String language;
}