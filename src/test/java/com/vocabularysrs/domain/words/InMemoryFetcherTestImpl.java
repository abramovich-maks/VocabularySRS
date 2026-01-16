package com.vocabularysrs.domain.words;

import com.vocabularysrs.domain.worddetails.WordDetailsFetchable;

class InMemoryFetcherTestImpl implements WordDetailsFetchable {

    WordDetailsSnapshot snapshot;

    InMemoryFetcherTestImpl() {
        this.snapshot = new WordDetailsSnapshot(
                "/ˈmʌðə/",
                "audio.mp3",
                "She is my mother."
        );
    }

    @Override
    public WordDetailsSnapshot fetch(String word) {
        return snapshot;
    }
}