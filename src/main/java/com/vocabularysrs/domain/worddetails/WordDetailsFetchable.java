package com.vocabularysrs.domain.worddetails;


import com.vocabularysrs.domain.words.WordDetailsSnapshot;

public interface WordDetailsFetchable {

    WordDetailsSnapshot fetch(String word);
}