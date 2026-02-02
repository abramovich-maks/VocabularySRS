package com.vocabularysrs.domain.words;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WordsGroupAlreadyExistsException extends RuntimeException {

    public final String groupName;

    public WordsGroupAlreadyExistsException(String groupName) {
        super("Group with name \"" + groupName + "\" already exists");
        this.groupName = groupName;
    }
}