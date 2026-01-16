package com.vocabularysrs.domain.worddetails;


import com.vocabularysrs.domain.words.WordDetailsSnapshot;

class InMemoryFetcherTestImpl implements WordDetailsFetchable {

    WordDetailsSnapshot snapshot;
    private int calls = 0;

    InMemoryFetcherTestImpl() {
        this.snapshot = new WordDetailsSnapshot(
                "/ˈmʌðə/",
                "audio.mp3",
                "She is my mother."
        );
    }

    @Override
    public WordDetailsSnapshot fetch(String word) {
        calls++;
        return snapshot;
    }

    int callsCount() {
        return calls;
    }
}