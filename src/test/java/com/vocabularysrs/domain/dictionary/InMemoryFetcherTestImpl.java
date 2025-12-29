package com.vocabularysrs.domain.dictionary;


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