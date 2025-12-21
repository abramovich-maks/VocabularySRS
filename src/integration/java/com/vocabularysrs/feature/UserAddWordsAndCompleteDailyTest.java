package com.vocabularysrs.feature;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vocabularysrs.BaseIntegrationTest;
import com.vocabularysrs.IntegrationTestData;
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
import com.vocabularysrs.infrastructure.dailytest.DailyTestControllerResponseDto;
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

class UserAddWordsAndCompleteDailyTest extends BaseIntegrationTest implements IntegrationTestData {

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

        final String CAT = "cat", CAT_RU = "кот";
        final String DOG = "dog", DOG_RU = "собака";
        final String SUN = "sun", SUN_RU = "солнце";
        final String CAR = "car", CAR_RU = "машина";

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
                .content(requestBodyWithAddCat().trim()
                )
                .contentType(MediaType.APPLICATION_JSON));
        // then
        MvcResult mvcResult = perform.andExpect(status().isOk()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        WordEntryControllerDtoResponse numberReceiverResponseDto = objectMapper.readValue(json, WordEntryControllerDtoResponse.class);
        assertAll(
                () -> assertThat(numberReceiverResponseDto.word()).isEqualTo(CAT),
                () -> assertThat(numberReceiverResponseDto.translate()).isEqualTo(CAT_RU),
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
                () -> assertThat(actual.word()).isEqualTo(CAT),
                () -> assertThat(actual.translate()).isEqualTo(CAT_RU)
        );


        //    step 4: user made POST /words with body (word: dog, translate: собака) at 19-12-2025 13:00, and the system returned OK (200) with message: "Success. New word added" and word: "dog", translate: "собака".
        // given && when && then
        mockMvc.perform(post("/words")
                .content(requestBodeWithAddDog().trim()
                )
                .contentType(MediaType.APPLICATION_JSON));


        //    step 5: user made POST /words with body (word: sun, translate: солнце) at 19-12-2025 14:00, and the system returned OK (200) with message: "Success. New word added" and word: "sun", translate: "солнце".
        // given && when && then
        mockMvc.perform(post("/words")
                .content(requestBodeWithAddSun().trim()
                )
                .contentType(MediaType.APPLICATION_JSON));


        //    step 6: user made POST /words with body (word: car, translate: машина) at 19-12-2025 15:00, and the system returned OK (200) with message: "Success. New word added" and word: "car", translate: "машина".
        // given && when && then
        mockMvc.perform(post("/words")
                .content(requestBodeWithAddCar().trim()
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
                        tuple(1L, CAT, CAT_RU),
                        tuple(2L, DOG, DOG_RU),
                        tuple(3L, SUN, SUN_RU),
                        tuple(4L, CAR, CAR_RU)
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
                () -> assertThat(responseWordIdTwo.word()).isEqualTo(DOG),
                () -> assertThat(responseWordIdTwo.translate()).isEqualTo(DOG_RU)
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

        // step 10: 19 hours and 1 minute passed (20.12.2025 06:01).
        clock.plusHours(19);
        clock.plusMinutes(1);
        assertThat(clock.instant()).isEqualTo("2025-12-20T06:01:00Z");


//    step 11: the system at 6:00 selected words for the user (3 words).
        dailyWordsSelectorFacade.retrieveWordsByDate();
        LocalDate day1 = clock.today();
        List<WordEntrySnapshot> wordEntriesByDay1 = wordEntryReadPort.findWordEntriesByNextReviewDate(day1);
        List<DailyWordSnapshot> dailyWordsByDay1 = dailyWordReadPort.findDailyWordReviewByTaskDate(day1);
        assertThat(wordEntriesByDay1).hasSize(3);
        assertThat(dailyWordsByDay1)
                .flatExtracting(DailyWordSnapshot::items)
                .extracting(ReviewWordItemSnapshot::wordEntryId, ReviewWordItemSnapshot::word, ReviewWordItemSnapshot::translation)
                .containsExactly(
                        tuple(1L, CAT, CAT_RU),
                        tuple(2L, DOG, DOG_RU),
                        tuple(4L, CAR, CAR_RU)
                );

//    step 12: the system at 6:05 generated a task with selected words for the date 20.12.2025.
        clock.plusMinutes(4);
        assertThat(clock.instant()).isEqualTo("2025-12-20T06:05:00Z");

        learningTaskGeneratorFacade.generateTasks(clock.today());
        LearningTaskSnapshot taskDay1 = learningTaskReadPort.findLearningTaskByDateAndUserId(day1, 1L);
        assertThat(taskDay1.questions())
                .hasSize(6)
                .extracting(QuestionSnapshot::wordEntryId, QuestionSnapshot::prompt, QuestionSnapshot::direction, QuestionSnapshot::answer)
                .containsExactly(
                        tuple(1L, CAT, WORD_TO_TRANSLATION, CAT_RU),
                        tuple(1L, CAT_RU, TRANSLATION_TO_WORD, CAT),
                        tuple(2L, DOG, WORD_TO_TRANSLATION, DOG_RU),
                        tuple(2L, DOG_RU, TRANSLATION_TO_WORD, DOG),
                        tuple(4L, CAR, WORD_TO_TRANSLATION, CAR_RU),
                        tuple(4L, CAR_RU, TRANSLATION_TO_WORD, CAR)
                );


//    step 13: user made POST /dailytest and requested 2 true and 4 false questions, and the server returned test statistics.
        // given && when
        ResultActions performResult = mockMvc.perform(post("/dailytest")
                .content(getRequestWithOneTrueAnswerCat()
                        .trim()
                )
                .contentType(MediaType.APPLICATION_JSON));
        // then
        MvcResult testResult = performResult.andExpect(status().isOk()).andReturn();
        String jsonResponse = testResult.getResponse().getContentAsString();
        DailyTestControllerResponseDto response = objectMapper.readValue(jsonResponse, DailyTestControllerResponseDto.class);

        assertThat(response.userId()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(6);
        assertThat(response.correct()).isEqualTo(2);
        assertThat(response.incorrect()).isEqualTo(4);


//    step 14: 1 day passed (21.12.2025 06:05).
        clock.plusDays(1);
        assertThat(clock.instant()).isEqualTo("2025-12-21T06:05:00Z");


//    step 15: the system at 6:00 selected words for the user (4 words).
        // given
        LocalDate day2 = clock.today();
        // when
        dailyWordsSelectorFacade.retrieveWordsByDate();
        List<WordEntrySnapshot> wordEntriesByDay2 = wordEntryReadPort.findWordEntriesByNextReviewDate(day2);
        List<DailyWordSnapshot> dailyWordsByDay2 = dailyWordReadPort.findDailyWordReviewByTaskDate(day2);
        // then
        assertThat(wordEntriesByDay2).hasSize(2);
        assertThat(dailyWordsByDay2)
                .flatExtracting(DailyWordSnapshot::items)
                .extracting(ReviewWordItemSnapshot::wordEntryId, ReviewWordItemSnapshot::word, ReviewWordItemSnapshot::translation)
                .containsExactly(
                        tuple(2L, DOG, DOG_RU),
                        tuple(4L, CAR, CAR_RU)
                );


//    step 16: the system at 6:05 generated a task with selected words for the date 21.12.2025.
        // given && when
        learningTaskGeneratorFacade.generateTasks(clock.today());
        // then
        LearningTaskSnapshot taskDay2 = learningTaskReadPort.findLearningTaskByDateAndUserId(day2, 1L);
        assertThat(taskDay2.questions())
                .hasSize(4)
                .extracting(QuestionSnapshot::wordEntryId, QuestionSnapshot::prompt, QuestionSnapshot::direction, QuestionSnapshot::answer)
                .containsExactly(
                        tuple(2L, DOG, WORD_TO_TRANSLATION, DOG_RU),
                        tuple(2L, DOG_RU, TRANSLATION_TO_WORD, DOG),
                        tuple(4L, CAR, WORD_TO_TRANSLATION, CAR_RU),
                        tuple(4L, CAR_RU, TRANSLATION_TO_WORD, CAR)
                );


//    step 17: user made POST /dailytest and requested 2 true questions, and the server returned test statistics.
        // given && when
        ResultActions lastPerform = mockMvc.perform(post("/dailytest")
                .content(getRequestWithTrueAnswersDogAndCar()
                        .trim()
                )
                .contentType(MediaType.APPLICATION_JSON));
        // then
        MvcResult actionResult = lastPerform.andExpect(status().isOk()).andReturn();
        String jsonWithTrueAnswersDogAndCar = actionResult.getResponse().getContentAsString();
        DailyTestControllerResponseDto responseWithTrueAnswersDogAndCar = objectMapper.readValue(jsonWithTrueAnswersDogAndCar, DailyTestControllerResponseDto.class);
        // then
        assertThat(responseWithTrueAnswersDogAndCar.userId()).isEqualTo(1);
        assertThat(responseWithTrueAnswersDogAndCar.total()).isEqualTo(4);
        assertThat(responseWithTrueAnswersDogAndCar.correct()).isEqualTo(4);
        assertThat(responseWithTrueAnswersDogAndCar.incorrect()).isEqualTo(0);


//    step 18: 2 days passed (23.12.2025 06:05).
        clock.plusDays(2);
        assertThat(clock.instant()).isEqualTo("2025-12-23T06:05:00Z");


//    step 19: the system at 6:00 selected words for the user (1 word).
        // given
        LocalDate day3 = clock.today();
        // when
        dailyWordsSelectorFacade.retrieveWordsByDate();
        // then
        List<WordEntrySnapshot> wordEntriesByDay3 = wordEntryReadPort.findWordEntriesByNextReviewDate(day3);
        List<DailyWordSnapshot> dailyWordsByDay3 = dailyWordReadPort.findDailyWordReviewByTaskDate(day3);
        assertThat(wordEntriesByDay3).hasSize(1);
        assertThat(dailyWordsByDay3)
                .flatExtracting(DailyWordSnapshot::items)
                .extracting(ReviewWordItemSnapshot::wordEntryId, ReviewWordItemSnapshot::word, ReviewWordItemSnapshot::translation)
                .containsExactly(
                        tuple(1L, CAT, CAT_RU)
                );


//    step 20: the system at 6:05 generated a task with selected words for the date 23.12.2025.
        // given && when
        learningTaskGeneratorFacade.generateTasks(clock.today());
        // then
        LearningTaskSnapshot taskDay3 = learningTaskReadPort.findLearningTaskByDateAndUserId(day3, 1L);
        assertThat(taskDay3.questions())
                .hasSize(2)
                .extracting(QuestionSnapshot::wordEntryId, QuestionSnapshot::prompt, QuestionSnapshot::direction, QuestionSnapshot::answer)
                .containsExactly(
                        tuple(1L, CAT, WORD_TO_TRANSLATION, CAT_RU),
                        tuple(1L, CAT_RU, TRANSLATION_TO_WORD, CAT)
                );
    }
}
