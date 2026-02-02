package com.vocabularysrs.domain.words;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WordsGroupNotFoundException extends RuntimeException {

    public final Long groupId;

    public WordsGroupNotFoundException(Long groupId) {
        super("Group with id: " + groupId + " not found");
        this.groupId = groupId;
    }
}