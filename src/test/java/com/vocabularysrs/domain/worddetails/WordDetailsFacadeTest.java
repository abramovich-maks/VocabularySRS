package com.vocabularysrs.domain.worddetails;

import com.vocabularysrs.domain.globalwords.GlobalWordFacade;
import com.vocabularysrs.domain.globalwords.dto.WordExampleListResponse;
import com.vocabularysrs.domain.globalwords.dto.WordExampleResponse;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.worddetails.dto.WordHttpDto;
import com.vocabularysrs.domain.words.WordEntryReadPort;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class WordDetailsFacadeTest {

    private final GlobalWordFacade globalWordFacade = Mockito.mock(GlobalWordFacade.class);

    private final InMemoryFetcherTestImpl fetcherTest = new InMemoryFetcherTestImpl();

    private final InMemoryWordDetailsRepositoryTestImpl detailsRepo = new InMemoryWordDetailsRepositoryTestImpl();
    private final CurrentUserProvider currentUserProvider = new TestCurrentUserProvider();
    private final WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl(1L, 1L, "mother");
    TranslationAlternativeServiceTestImpl translationAlternativeService = new TranslationAlternativeServiceTestImpl();
    private final WordDetailsFacade facadeTest = new WordDetailsConfiguration().detailsFacade(detailsRepo, wordEntryReadPort, fetcherTest, currentUserProvider, translationAlternativeService, globalWordFacade);


    @Test
    void should_return_details_from_db_when_they_are_there() {
        // given
        Long wordId = 1L;
        WordDetailsEntry existing = WordDetailsEntry.builder()
                .wordId(wordId)
                .userId(currentUserProvider.getCurrentUserId())
                .phonetic("phonetic")
                .audioUrl("audio")
                .build();
        detailsRepo.save(existing);
        WordExampleListResponse response = new WordExampleListResponse(
                List.of(new WordExampleResponse(wordId, "She is my mother.")));
        when(globalWordFacade.findExampleByWord(Mockito.any())).thenReturn(response);
        // when
        WordHttpDto result = facadeTest.getOrLoad(wordId);
        // then
        assertEquals("She is my mother.", result.examples().stream().map(ex -> ex.example()).toList().get(0));
        assertEquals(0, fetcherTest.callsCount());
    }


    @Test
    void should_check_db_and_if_not_details_then_load_from_api() {
        // given
        Long wordId = 1L;
        // when
        WordExampleListResponse response = new WordExampleListResponse(
                List.of(new WordExampleResponse(wordId, "She is my mother.")));
        when(globalWordFacade.findExampleByWord(Mockito.any())).thenReturn(response);
        WordHttpDto result = facadeTest.getOrLoad(wordId);
        // then
        assertEquals("She is my mother.", result.examples().stream().map(WordExampleResponse::example).toList().get(0));
        assertEquals(1, fetcherTest.callsCount());
        assertTrue(detailsRepo.findByWordIdAndUserId(wordId, currentUserProvider.getCurrentUserId()).isPresent());
    }

    @Test
    void should_load_and_save_alternative_translations() {
        // given
        Long wordId = 1L;
        WordExampleListResponse response = new WordExampleListResponse(
                List.of(new WordExampleResponse(wordId, "She is my mother.")));
        when(globalWordFacade.findExampleByWord(Mockito.any())).thenReturn(response);
        // when
        WordHttpDto result = facadeTest.getOrLoad(wordId);

        // then
        assertEquals(List.of("мать", "мама"), result.alternatives());

        WordDetailsEntry saved =
                detailsRepo.findByWordIdAndUserId(
                        wordId,
                        currentUserProvider.getCurrentUserId()
                ).orElseThrow();

        List<String> storedAlternatives = saved.getAlternatives()
                .stream()
                .map(WordDetailsAlternativeTranslation::getAlternativeTranslate)
                .toList();

        assertEquals(List.of("мать", "мама"), storedAlternatives);
    }

}