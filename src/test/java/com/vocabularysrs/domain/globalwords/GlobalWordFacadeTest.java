package com.vocabularysrs.domain.globalwords;

import com.vocabularysrs.domain.globalwords.dto.GlobalWordRequest;
import com.vocabularysrs.domain.globalwords.dto.GlobalWordResponse;
import com.vocabularysrs.domain.globalwords.dto.WordExampleListResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GlobalWordFacadeTest {

    GlobalWordsRepository wordsRepository = new GlobalWordsRepositoryTestImpl();
    ExampleRepository exampleRepository = new ExampleRepositoryTestImpl();
    ExampleAsyncGenerator asyncGenerator = Mockito.mock(ExampleAsyncGenerator.class);
    GlobalWordRetriever wordRetriever = new GlobalWordRetriever(wordsRepository);
    GlobalWordAdder wordAdder = new GlobalWordAdder(wordsRepository, asyncGenerator, wordRetriever);
    WordExampleRetriever exampleRetriever = new WordExampleRetriever(exampleRepository, wordRetriever);
    GlobalWordFacade facade = new GlobalWordFacade(wordAdder, exampleRetriever);

    @Test
    void should_not_add_if_exists() {
        // given
        facade.addWordToGlobal(new GlobalWordRequest("cat"));
        // when
        GlobalWordResponse result = facade.addWordToGlobal(new GlobalWordRequest("cat"));
        // then
        Assertions.assertNull(result.globalWordId());
        verify(asyncGenerator, times(1)).generateAndSaveExamples(any(), any());
    }

    @Test
    void should_add_new_word() {
        //given && when
        GlobalWordResponse result = facade.addWordToGlobal(new GlobalWordRequest("cat"));
        // then
        Assertions.assertNotNull(result.globalWordId());
        Assertions.assertEquals("cat", result.globalWord());
        verify(asyncGenerator).generateAndSaveExamples(eq("cat"), any());
    }

    @Test
    void should_normalize_word_before_save() {

        GlobalWordResponse result =
                facade.addWordToGlobal(
                        new GlobalWordRequest("  CAT ")
                );

        Assertions.assertEquals("cat", result.globalWord());
    }

    @Test
    void should_return_examples_for_word() {
        // given
        facade.addWordToGlobal(new GlobalWordRequest("cat"));
        GlobalWord word = wordsRepository.findByWord("cat").orElseThrow();
        exampleRepository.save(new WordExample(null, "I saw a cat yesterday.", word));
        // when
        WordExampleListResponse result = facade.findExampleByWord(new GlobalWordRequest("cat"));
        // then
        Assertions.assertEquals(1, result.example().size());
        Assertions.assertEquals("I saw a cat yesterday.", result.example().get(0).example());
    }

    @Test
    void should_throw_when_word_not_found() {
        // given && when && then
        Assertions.assertThrows(GlobalWordNotFoundException.class, () -> facade.findExampleByWord(new GlobalWordRequest("cat")));
    }
}