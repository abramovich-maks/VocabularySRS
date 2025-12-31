package com.vocabularysrs.feature;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vocabularysrs.BaseIntegrationTest;
import com.vocabularysrs.IntegrationTestData;
import com.vocabularysrs.domain.dailytest.dto.DailyTestShowResponseDto;
import com.vocabularysrs.domain.dictionary.DictionaryFacade;
import com.vocabularysrs.domain.dictionary.dto.WordDtoResponse;
import com.vocabularysrs.domain.security.CurrentUserProvider;
import com.vocabularysrs.infrastructure.dailytest.DailyTestControllerResponseDto;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.DeletedWordEntryControllerDtoResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.GetAllWordsResponseDto;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordDtoControllerResponse;
import com.vocabularysrs.infrastructure.dictionary.controller.dto.WordEntryControllerDtoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

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
    DictionaryFacade dictionaryFacade;

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
        GetAllWordsResponseDto emptyWordsResponse = objectMapper.readValue(jsonEmptyWords, new TypeReference<>() {
        });
        assertThat(emptyWordsResponse.dtoResponse()).isEmpty();


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
        GetAllWordsResponseDto responseWithOneWord = objectMapper.readValue(jsonWithOneWord, new TypeReference<>() {
        });
        WordDtoControllerResponse actual = responseWithOneWord.dtoResponse().get(0);
        assertAll(
                () -> assertThat(responseWithOneWord.dtoResponse().size()).isEqualTo(1),
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

        List<WordDtoResponse> allWords = dictionaryFacade.findAllWords(Pageable.unpaged());
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
        MvcResult getTest = firstDailyTestRequest.andExpect(status().isOk()).andReturn();
        String jsonGetResponse = getTest.getResponse().getContentAsString();
        DailyTestShowResponseDto getResponse = objectMapper.readValue(jsonGetResponse, DailyTestShowResponseDto.class);

        assertThat(getResponse.userId()).isEqualTo(1);
        assertThat(getResponse.id()).isNotNull();
        assertThat(getResponse.taskDate()).isEqualTo(adjustableClock().today());
        assertThat(getResponse.questions().size()).isEqualTo(6);


// step 12: user made POST /dailytest and requested 2 true and 4 false questions, and the server returned test statistics.
        // given && when
        ResultActions submitFirstTestResult = mockMvc.perform(post("/dailytest")
                .content(getRequestWithOneTrueAnswerCat()
                        .trim()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult testResult = submitFirstTestResult.andExpect(status().isOk()).andReturn();
        String jsonResponse = testResult.getResponse().getContentAsString();
        DailyTestControllerResponseDto response = objectMapper.readValue(jsonResponse, DailyTestControllerResponseDto.class);

        assertThat(response.userId()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(6);
        assertThat(response.correct()).isEqualTo(2);
        assertThat(response.incorrect()).isEqualTo(4);


// step 13: system time is advanced to 2025-12-21T06:01 (next day morning)
        adjustableClock().plusDays(1);
        assertThat(adjustableClock().instant()).isEqualTo("2025-12-21T06:01:00Z");


// step 14: user made GET /dailytest and the server returned daily test.
        // given && when
        ResultActions secondDailyTestRequest = mockMvc.perform(get("/dailytest")
                        .header("Authorization", authenticatedUser()))
                .andExpect(status().isOk());
        MvcResult getTest1 = secondDailyTestRequest.andExpect(status().isOk()).andReturn();
        String jsonGetResponse1 = getTest1.getResponse().getContentAsString();
        DailyTestShowResponseDto getResponse1 = objectMapper.readValue(jsonGetResponse1, DailyTestShowResponseDto.class);

        assertThat(getResponse1.userId()).isEqualTo(1);
        assertThat(getResponse1.id()).isNotNull();
        assertThat(getResponse1.taskDate()).isEqualTo(adjustableClock().today());
        assertThat(getResponse1.questions().size()).isEqualTo(4);


// step 15: user made POST /dailytest and requested 2 true questions, and the server returned test statistics.
        // given && when
        ResultActions submitSecondTestResult = mockMvc.perform(post("/dailytest")
                .content(getRequestWithTrueAnswersDogAndCar()
                        .trim()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult actionResult = submitSecondTestResult.andExpect(status().isOk()).andReturn();
        String jsonWithTrueAnswersDogAndCar = actionResult.getResponse().getContentAsString();
        DailyTestControllerResponseDto responseWithTrueAnswersDogAndCar = objectMapper.readValue(jsonWithTrueAnswersDogAndCar, DailyTestControllerResponseDto.class);
        // then
        assertThat(responseWithTrueAnswersDogAndCar.userId()).isEqualTo(1);
        assertThat(responseWithTrueAnswersDogAndCar.total()).isEqualTo(4);
        assertThat(responseWithTrueAnswersDogAndCar.correct()).isEqualTo(4);
        assertThat(responseWithTrueAnswersDogAndCar.incorrect()).isEqualTo(0);


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
        ResultActions submitFinalTestResult = mockMvc.perform(post("/dailytest")
                .content(getRequestWithAllTrueQuestions()
                        .trim()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authenticatedUser()));
        // then
        MvcResult actionResult20Days = submitFinalTestResult.andExpect(status().isOk()).andReturn();
        String jsonWithAllTrueAnswers = actionResult20Days.getResponse().getContentAsString();
        DailyTestControllerResponseDto responseWithAllTrueAnswers = objectMapper.readValue(jsonWithAllTrueAnswers, DailyTestControllerResponseDto.class);
        // then
        assertThat(responseWithAllTrueAnswers.userId()).isEqualTo(1);
        assertThat(responseWithAllTrueAnswers.total()).isEqualTo(6);
        assertThat(responseWithAllTrueAnswers.correct()).isEqualTo(6);
        assertThat(responseWithAllTrueAnswers.incorrect()).isEqualTo(0);
    }
}
