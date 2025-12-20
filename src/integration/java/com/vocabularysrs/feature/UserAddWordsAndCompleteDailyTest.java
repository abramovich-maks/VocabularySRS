package com.vocabularysrs.feature;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vocabularysrs.BaseIntegrationTest;
import com.vocabularysrs.domain.dailywordsselector.DailyWordReadPort;
import com.vocabularysrs.domain.dailywordsselector.DailyWordSnapshot;
import com.vocabularysrs.domain.dailywordsselector.DailyWordsSelectorFacade;
import com.vocabularysrs.domain.dailywordsselector.ReviewWordItemSnapshot;
import com.vocabularysrs.domain.dictionary.DictionaryFacade;
import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
import com.vocabularysrs.domain.dictionary.WordEntrySnapshot;
import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskGeneratorFacade;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskReadPort;
import com.vocabularysrs.domain.learningtaskgenerator.LearningTaskSnapshot;
import com.vocabularysrs.domain.learningtaskgenerator.QuestionSnapshot;
import com.vocabularysrs.infrastructure.dictionary.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.dto.GetAllWordsResponseDto;
import com.vocabularysrs.infrastructure.dictionary.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.dto.WordEntryControllerDtoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.List;

import static com.vocabularysrs.domain.learningtaskgenerator.TranslationDirection.TRANSLATION_TO_WORD;
import static com.vocabularysrs.domain.learningtaskgenerator.TranslationDirection.WORD_TO_TRANSLATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserAddWordsAndCompleteDailyTest extends BaseIntegrationTest {

    @Autowired
    DailyWordsSelectorFacade dailyWordsSelectorFacade;

    @Autowired
    DictionaryFacade dictionaryFacade;

    @Autowired
    WordEntryReadPort wordEntryReadPort;

    @Autowired
    DailyWordReadPort dailyWordReadPort;

    @Autowired
    LearningTaskReadPort learningTaskReadPort;

    @Autowired
    LearningTaskGeneratorFacade learningTaskGeneratorFacade;

    @Test
    public void happyPath() throws Exception {
        //    step 1: user made GET /words and sees 0 words.
        // given && when
        ResultActions performEmptyResults = mockMvc.perform(get("/words"));
        // then
        MvcResult mvcResultZeroWords = performEmptyResults.andExpect(status().isOk()).andReturn();
        String jsonEmptyWords = mvcResultZeroWords.getResponse().getContentAsString();
        GetAllWordsResponseDto emptyWordsResponse = objectMapper.readValue(jsonEmptyWords, new TypeReference<>() {
        });
        assertThat(emptyWordsResponse.dtoResponse()).isEmpty();


        //    step 2: user made POST /words with body (word: cat, translate: кот) at 19-12-2025 12:00, and the system returned OK (200) with message: "Success. New word added" and word: "cat", translate: "кот".
        // given
        // when
        ResultActions perform = mockMvc.perform(post("/words")
                .content("""
                        {
                        "word" : "cat",
                        "translate" : "кот"
                        }
                        """.trim()
                )
                .contentType(MediaType.APPLICATION_JSON));
        // then
        MvcResult mvcResult = perform.andExpect(status().isOk()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        WordEntryControllerDtoResponse numberReceiverResponseDto = objectMapper.readValue(json, WordEntryControllerDtoResponse.class);
        assertAll(
                () -> assertThat(numberReceiverResponseDto.word()).isEqualTo("cat"),
                () -> assertThat(numberReceiverResponseDto.translate()).isEqualTo("кот"),
                () -> assertThat(numberReceiverResponseDto.message()).isEqualTo("Success. New word added")
        );


        //    step 3: user made GET /words and sees 1 word.
        // given && when
        ResultActions performGetResults = mockMvc.perform(get("/words"));
        // then
        MvcResult mvcResultOneWord = performGetResults.andExpect(status().isOk()).andReturn();
        String jsonWithOneWord = mvcResultOneWord.getResponse().getContentAsString();
        GetAllWordsResponseDto responseWithOneWord = objectMapper.readValue(jsonWithOneWord, new TypeReference<>() {
        });
        WordDtoControllerResponse actual = responseWithOneWord.dtoResponse().get(0);
        assertAll(
                () -> assertThat(responseWithOneWord.dtoResponse().size()).isEqualTo(1),
                () -> assertThat(actual.id()).isEqualTo(1L),
                () -> assertThat(actual.word()).isEqualTo("cat"),
                () -> assertThat(actual.translate()).isEqualTo("кот")
        );


        //    step 4: user made POST /words with body (word: dog, translate: собака) at 19-12-2025 13:00, and the system returned OK (200) with message: "Success. New word added" and word: "dog", translate: "собака".
        //    step 5: user made POST /words with body (word: sun, translate: солнце) at 19-12-2025 14:00, and the system returned OK (200) with message: "Success. New word added" and word: "sun", translate: "солнце".
        //    step 6: user made POST /words with body (word: car, translate: машина) at 19-12-2025 15:00, and the system returned OK (200) with message: "Success. New word added" and word: "car", translate: "машина".
        // given && when && then
        mockMvc.perform(post("/words")
                .content("""
                        {
                        "word" : "dog",
                        "translate" : "собака"
                        }
                        """.trim()
                )
                .contentType(MediaType.APPLICATION_JSON));

        mockMvc.perform(post("/words")
                .content("""
                        {
                        "word" : "sun",
                        "translate" : "солнце"
                        }
                        """.trim()
                )
                .contentType(MediaType.APPLICATION_JSON));

        mockMvc.perform(post("/words")
                .content("""
                        {
                        "word" : "car",
                        "translate" : "машина"
                        }
                        """.trim()
                )
                .contentType(MediaType.APPLICATION_JSON));


        //    step 7: user made GET /words and sees 4 words.
        // given && when
        ResultActions performGetResultsWithFourWords = mockMvc.perform(get("/words"));
        // then
        MvcResult mvcResultFourWords = performGetResultsWithFourWords.andExpect(status().isOk()).andReturn();
        String jsonWithFourWords = mvcResultFourWords.getResponse().getContentAsString();
        GetAllWordsResponseDto responseWithFourWords = objectMapper.readValue(jsonWithFourWords, new TypeReference<>() {
        });
        assertThat(responseWithFourWords.dtoResponse())
                .hasSize(4)
                .extracting(WordDtoControllerResponse::id, WordDtoControllerResponse::word, WordDtoControllerResponse::translate)
                .containsExactly(
                        tuple(1L, "cat", "кот"),
                        tuple(2L, "dog", "собака"),
                        tuple(3L, "sun", "солнце"),
                        tuple(4L, "car", "машина")
                );


        //    step 8: user made GET /words/2, and the system returned id: "2", word: "dog", translate: "собака".
        // given && when
        ResultActions performGetResultsWordIdTwo = mockMvc.perform(get("/words/2"));
        // then
        MvcResult mvcResultWordIdTwo = performGetResultsWordIdTwo.andExpect(status().isOk()).andReturn();
        String jsonWithWordIdTwo = mvcResultWordIdTwo.getResponse().getContentAsString();
        WordDtoControllerResponse responseWordIdTwo = objectMapper.readValue(jsonWithWordIdTwo, new TypeReference<>() {
        });
        assertAll(
                () -> assertThat(responseWordIdTwo.id()).isEqualTo(2L),
                () -> assertThat(responseWordIdTwo.word()).isEqualTo("dog"),
                () -> assertThat(responseWordIdTwo.translate()).isEqualTo("собака")
        );


//    step 9: user made DELETE /words/3, and the system deleted the word with id 3 and returned the message: "Deleted word by id: 3".
        // given && when
        ResultActions performDelete = mockMvc.perform(delete("/words/3"));
        // then
        MvcResult mvcDeleteResponse = performDelete.andExpect(status().isOk()).andReturn();
        String jsonDelete = mvcDeleteResponse.getResponse().getContentAsString();
        DeletedWordEntryControllerDtoResponse deleteResponse = objectMapper.readValue(jsonDelete, new TypeReference<>() {
        });
        assertThat(deleteResponse.message()).isEqualTo("Deleted word by id: 3");

        List<WordDtoResponse> allWords = dictionaryFacade.findAllWords(Pageable.unpaged());
        assertThat(allWords).hasSize(3);

        // step 10: 15 hours and 1 minute passed (20.12.2025 06:01).
        clock.plusMinutes((60 * 19) + 1);


//    step 11: the system at 6:00 selected words for the user (3 words).
        dailyWordsSelectorFacade.retrieveWordsByDate();
        LocalDate targetDate = LocalDate.of(2025, 12, 20);
        List<WordEntrySnapshot> wordEntriesByNextReviewDate = wordEntryReadPort.findWordEntriesByNextReviewDate(targetDate);
        List<DailyWordSnapshot> dailyWordReviewByTaskDate = dailyWordReadPort.findDailyWordReviewByTaskDate(targetDate);
        assertThat(wordEntriesByNextReviewDate).hasSize(3);
        assertThat(dailyWordReviewByTaskDate)
                .flatExtracting(DailyWordSnapshot::items)
                .extracting(ReviewWordItemSnapshot::wordEntryId, ReviewWordItemSnapshot::word, ReviewWordItemSnapshot::translation)
                .containsExactly(
                        tuple(1L, "cat", "кот"),
                        tuple(2L, "dog", "собака"),
                        tuple(4L, "car", "машина")
                );

//    step 12: the system at 6:05 generated a task with selected words for the date 20.12.2025.
        clock.plusMinutes(4);
        learningTaskGeneratorFacade.generateTasks();
        LearningTaskSnapshot learningTaskByDateAndUserId = learningTaskReadPort.findLearningTaskByDateAndUserId(targetDate, 1L);
        assertThat(learningTaskByDateAndUserId.questions())
                .hasSize(6)
                .extracting(QuestionSnapshot::wordEntryId, QuestionSnapshot::prompt, QuestionSnapshot::direction, QuestionSnapshot::answer)
                .containsExactly(
                        tuple(1L, "cat", WORD_TO_TRANSLATION, "кот"),
                        tuple(1L, "кот", TRANSLATION_TO_WORD, "cat"),
                        tuple(2L, "dog", WORD_TO_TRANSLATION, "собака"),
                        tuple(2L, "собака", TRANSLATION_TO_WORD, "dog"),
                        tuple(4L, "car", WORD_TO_TRANSLATION, "машина"),
                        tuple(4L, "машина", TRANSLATION_TO_WORD, "car")
                );


//    step 13: user made POST /dailytest and requested 1 true and 2 false questions, and the server returned test statistics.
//    step 14: 1 day passed (21.12.2025 06:01).
//    step 15: the system at 6:00 selected words for the user (2 words).
//    step 16: the system at 6:05 generated a task with selected words for the date 21.12.2025.
//    step 17: user made POST /dailytest and requested 2 true questions, and the server returned test statistics.
//    step 18: 2 days passed (23.12.2025 06:01).
//    step 19: the system at 6:00 selected words for the user (1 word).
//    step 20: the system at 6:05 generated a task with selected words for the date 23.12.2025.
    }
}
