package com.vocabularysrs.domain.dictionary;


import com.vocabularysrs.domain.worddetails.WordDetailsFetchable;
import com.vocabularysrs.domain.worddetails.WordHttpDto;

public class InMemoryFetcherTestImpl implements WordDetailsFetchable {

    WordHttpDto wordHttpDto;

    InMemoryFetcherTestImpl(WordHttpDto wordHttpDto) {
        this.wordHttpDto = wordHttpDto;
    }


    @Override
    public WordHttpDto details(final String word) {
        return wordHttpDto;
    }
}