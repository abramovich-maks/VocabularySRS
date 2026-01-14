package com.vocabularysrs.domain.loginandregister;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserLanguage {
    RU("ru"),
    PL("pl"),
    DE("de");

    private final String language;
}