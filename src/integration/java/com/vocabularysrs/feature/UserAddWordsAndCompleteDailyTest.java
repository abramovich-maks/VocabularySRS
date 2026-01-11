package com.vocabularysrs.feature;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vocabularysrs.BaseIntegrationTest;
import com.vocabularysrs.IntegrationTestData;
import com.vocabularysrs.PageResponse;
import com.vocabularysrs.domain.dailytest.dto.DailyTestResponseDto;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
import com.vocabularysrs.domain.dailytest.dto.QuestionDto;
import com.vocabularysrs.domain.learningtaskgenerator.AnswerResult;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.domain.words.WordsFacade;
import com.vocabularysrs.domain.words.dto.WordDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserAddWordsAndCompleteDailyTest extends BaseIntegrationTest implements IntegrationTestData {

    @Autowired
    WordsFacade wordsFacade;

    @MockitoBean
    AuthenticationManager authenticationManager;

    @MockitoBean
    private CurrentUserProvider currentUserProvider;

    @BeforeEach
    void setupAuth() {
        when(authenticationManager.authenticate(any()))
                .thenReturn(mock(Authentication.class));
    }

    @Test
    public void should_handle_full_srs_flow_with_skipped_days() throws Exception {

        final String CAT = "cat", CAT_RU = "кот";
        final String DOG = "dog", DOG_RU = "собака";
        final String SUN = "sun", SUN_RU = "солнце";
        final String CAR = "car", CAR_RU = "машина";


// step 1: user made GET /words and sees 0 words.
        // given && when
        ResultActions performEmptyResults = mockMvc.perform(get("/words")
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult mvcResultZeroWords = performEmptyResults.andExpect(status().isOk()).andReturn();
        String jsonEmptyWords = mvcResultZeroWords.getResponse().getContentAsString();
        PageResponse<WordDtoControllerResponse> emptyWordsResponse = objectMapper.readValue(jsonEmptyWords, new TypeReference<>() {
        });
        assertThat(emptyWordsResponse.content()).isEmpty();


// step 2: user made POST /words with body (word: cat, translate: кот) at 19-12-2025 12:00, and the system returned OK (200) with message: "Success. New word added" and word: "cat", translate: "кот".
        // given && when
        when(currentUserProvider.getCurrentUserId()).thenReturn(1L);
        ResultActions addCatRequest = mockMvc.perform(post("/words")
                .content(requestBodyWithAddCat().trim()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult mvcResult = addCatRequest.andExpect(status().isOk()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        WordEntryControllerDtoResponse numberReceiverResponseDto = objectMapper.readValue(json, WordEntryControllerDtoResponse.class);
        assertAll(
                () -> assertThat(numberReceiverResponseDto.word()).isEqualTo(CAT),
                () -> assertThat(numberReceiverResponseDto.translate()).isEqualTo(CAT_RU),
                () -> assertThat(numberReceiverResponseDto.message()).isEqualTo("Success. New word added")
        );


// step 3: user made GET /words and sees 1 word.
        // given && when
        ResultActions getAllWordsRequest = mockMvc.perform(get("/words")
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult mvcResultOneWord = getAllWordsRequest.andExpect(status().isOk()).andReturn();
        String jsonWithOneWord = mvcResultOneWord.getResponse().getContentAsString();
        PageResponse<WordDtoControllerResponse> responseWithOneWord = objectMapper.readValue(jsonWithOneWord, new TypeReference<>() {
        });
        WordDtoControllerResponse actual = responseWithOneWord.content().get(0);
        assertAll(
                () -> assertThat(responseWithOneWord.content().size()).isEqualTo(1),
                () -> assertThat(actual.id()).isEqualTo(1L),
                () -> assertThat(actual.word()).isEqualTo(CAT),
                () -> assertThat(actual.translate()).isEqualTo(CAT_RU)
        );


// step 4: user made POST /words with body (word: dog, translate: собака)  and the system returned OK (200) with message: "Success. New word added" and word: "dog", translate: "собака".
        // given && when && then
        mockMvc.perform(post("/words")
                .content(requestBodeWithAddDog().trim()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authenticatedUser()));


// step 5: user made POST /words with body (word: sun, translate: солнце)  and the system returned OK (200) with message: "Success. New word added" and word: "sun", translate: "солнце".
        // given && when && then
        mockMvc.perform(post("/words")
                .content(requestBodeWithAddSun().trim()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authenticatedUser()));


// step 6: user made POST /words with body (word: car, translate: машина)  and the system returned OK (200) with message: "Success. New word added" and word: "car", translate: "машина".
        // given && when && then
        mockMvc.perform(post("/words")
                .content(requestBodeWithAddCar().trim()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authenticatedUser()));


// step 7: user made GET /words and sees 4 words.
        // given && when
        ResultActions getAllWordsAfterAddingRequest = mockMvc.perform(get("/words")
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult mvcResultFourWords = getAllWordsAfterAddingRequest.andExpect(status().isOk()).andReturn();
        String jsonWithFourWords = mvcResultFourWords.getResponse().getContentAsString();
        PageResponse<WordDtoControllerResponse> responseWithFourWords = objectMapper.readValue(jsonWithFourWords, new TypeReference<>() {
        });
        assertThat(responseWithFourWords.content())
                .hasSize(4)
                .extracting(WordDtoControllerResponse::id, WordDtoControllerResponse::word, WordDtoControllerResponse::translate)
                .containsExactly(
                        tuple(1L, CAT, CAT_RU),
                        tuple(2L, DOG, DOG_RU),
                        tuple(3L, SUN, SUN_RU),
                        tuple(4L, CAR, CAR_RU)
                );


// step 8: user made GET /words/2, and the system returned id: "2", word: "dog", translate: "собака".
        // given && when
        ResultActions performGetResultsWordIdTwo = mockMvc.perform(get("/words/2")
                .header("Authorization", authenticatedUser()));
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


// step 9: user made DELETE /words/3, and the system deleted the word with id 3 and returned the message: "Deleted word by id: 3".
        // given && when
        ResultActions performDelete = mockMvc.perform(delete("/words/3")
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult mvcDeleteResponse = performDelete.andExpect(status().isOk()).andReturn();
        String jsonDelete = mvcDeleteResponse.getResponse().getContentAsString();
        DeletedWordEntryControllerDtoResponse deleteResponse = objectMapper.readValue(jsonDelete, new TypeReference<>() {
        });
        assertThat(deleteResponse.message()).isEqualTo("Deleted word by id: 3");

        Page<WordDtoResponse> allWords = wordsFacade.findAllWords(Pageable.unpaged());
        assertThat(allWords).hasSize(3);


// step 10: system time is advanced to 2025-12-20T06:01 (next day morning)
        adjustableClock().plusHours(19);
        adjustableClock().plusMinutes(1);
        assertThat(adjustableClock().instant()).isEqualTo("2025-12-20T06:01:00Z");


// step 11: user made GET /dailytest and the server returned daily test.
        // given && when
        ResultActions firstDailyTestRequest = mockMvc.perform(get("/dailytest")
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult dailyTestResponse = firstDailyTestRequest.andExpect(status().isOk()).andReturn();
        String jsonGetResponse = dailyTestResponse.getResponse().getContentAsString();
        DailyTestShowResponseDto getResponse = objectMapper.readValue(jsonGetResponse, DailyTestShowResponseDto.class);

        assertThat(getResponse.userId()).isEqualTo(1);
        assertThat(getResponse.id()).isNotNull();
        assertThat(getResponse.taskDate()).isEqualTo(adjustableClock().today());
        assertThat(getResponse.questions().size()).isEqualTo(6);


// step 12: user made POST /dailytest and requested 2 true and 4 false questions, and the server returned test statistics.
        // given && when
        AnswerResult question1 = answerQuestion(mockMvc, objectMapper, authenticatedUser(), 1, "кот");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 2, "cat");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 3, "qwe");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 4, "qwe");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 5, "qwe");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 6, "qwe");
        // then
        assertThat(question1.questionId()).isEqualTo(1);
        assertThat(question1.wordEntryId()).isEqualTo(1);
        assertThat(question1.userAnswer()).isEqualTo("кот");
        assertThat(question1.correctAnswer()).isEqualTo("кот");


        MvcResult summaryResponse = mockMvc.perform(post("/dailytest/result")
                        .header("Authorization", authenticatedUser())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();
        DailyTestResponseDto summary = objectMapper.readValue(summaryResponse.getResponse().getContentAsString(), DailyTestResponseDto.class);

        assertThat(summary.userId()).isEqualTo(1L);
        assertThat(summary.total()).isEqualTo(6);
        assertThat(summary.correct()).isEqualTo(2);
        assertThat(summary.incorrect()).isEqualTo(4);
        assertThat(summary.answers()).hasSize(6);
        assertThat(summary.answers())
                .extracting(AnswerResult::correct)
                .containsExactly(true, true, false, false, false, false);


// step 13: system time is advanced to 2025-12-21T06:01 (next day morning)
        adjustableClock().plusDays(1);
        assertThat(adjustableClock().instant()).isEqualTo("2025-12-21T06:01:00Z");


// step 14: user made GET /dailytest and the server returned daily test.
        // given && when
        ResultActions secondDailyTestRequest = mockMvc.perform(get("/dailytest")
                        .header("Authorization", authenticatedUser()))
                .andExpect(status().isOk());
        MvcResult secondDayDailyTestResponse = secondDailyTestRequest.andExpect(status().isOk()).andReturn();
        String jsonGetResponse1 = secondDayDailyTestResponse.getResponse().getContentAsString();
        DailyTestShowResponseDto getResponse1 = objectMapper.readValue(jsonGetResponse1, DailyTestShowResponseDto.class);

        assertThat(getResponse1.userId()).isEqualTo(1);
        assertThat(getResponse1.id()).isNotNull();
        assertThat(getResponse1.taskDate()).isEqualTo(adjustableClock().today());
        assertThat(getResponse1.questions().size()).isEqualTo(4);
        assertThat(getResponse1.questions())
                .extracting(QuestionDto::wordEntryId)
                .doesNotContain(3L);


// step 15: user made POST /dailytest and requested 2 true questions, and the server returned test statistics.
        // given && when
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 7, "собака");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 8, "dog");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 9, "машина");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 10, "car");

        MvcResult secondDaySummaryResponse = mockMvc.perform(post("/dailytest/result")
                        .header("Authorization", authenticatedUser())
                )
                .andExpect(status().isOk())
                .andReturn();

        DailyTestResponseDto summary2 = objectMapper.readValue(secondDaySummaryResponse.getResponse().getContentAsString(), DailyTestResponseDto.class);

        assertThat(summary2.total()).isEqualTo(4);
        assertThat(summary2.correct()).isEqualTo(4);
        assertThat(summary2.incorrect()).isEqualTo(0);

// step 16: time moves forward to 2026-01-10T06:01 (after long inactivity)
        adjustableClock().plusDays(20);
        assertThat(adjustableClock().instant()).isEqualTo("2026-01-10T06:01:00Z");


// step 17: user made GET /dailytest and the server returned daily test.
        // given && when
        ResultActions dailyTestAfterLongBreakRequest = mockMvc.perform(get("/dailytest")
                        .header("Authorization", authenticatedUser()))
                .andExpect(status().isOk());
        MvcResult getTestAfter20Days = dailyTestAfterLongBreakRequest.andExpect(status().isOk()).andReturn();
        String jsonGetResponse20Days = getTestAfter20Days.getResponse().getContentAsString();
        DailyTestShowResponseDto getResponse20Days = objectMapper.readValue(jsonGetResponse20Days, DailyTestShowResponseDto.class);

        assertThat(getResponse20Days.userId()).isEqualTo(1);
        assertThat(getResponse20Days.id()).isNotNull();
        assertThat(getResponse20Days.taskDate()).isEqualTo(adjustableClock().today());
        assertThat(getResponse20Days.questions().size()).isEqualTo(6);


// step 18: user made POST /dailytest and requested 2 true questions, and the server returned test statistics.
        // given && when
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 11, "кот");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 12, "cat");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 13, "собака");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 14, "dog");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 15, "машина");
        answerQuestion(mockMvc, objectMapper, authenticatedUser(), 16, "car");

        MvcResult finalSummaryResponse = mockMvc.perform(post("/dailytest/result")
                        .header("Authorization", authenticatedUser())
                )
                .andExpect(status().isOk())
                .andReturn();

        DailyTestResponseDto summaryFinal = objectMapper.readValue(finalSummaryResponse.getResponse().getContentAsString(), DailyTestResponseDto.class);

        assertThat(summaryFinal.total()).isEqualTo(6);
        assertThat(summaryFinal.correct()).isEqualTo(6);
        assertThat(summaryFinal.incorrect()).isEqualTo(0);
        assertThat(summaryFinal.answers())
                .allMatch(AnswerResult::correct);


        mockMvc.perform(get("/dailytest")
                        .header("Authorization", authenticatedUser()))
                .andExpect(status().isNoContent());
    }
}
