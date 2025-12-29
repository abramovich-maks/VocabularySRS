package com.vocabularysrs.domain.dictionary;


public interface WordDetailsFetchable {

    WordHttpDto details(String word);
}