package com.vocabularysrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vocabularysrs.domain.learningtest.dto.AnswerResultDto;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public interface IntegrationTestData {

    default String requestBodyWithAddCat() {
        return """
                {
                "word" : "cat",
                "translate" : "кот"
                }
                """;
    }


    default String requestBodeWithAddCar() {
        return """
                {
                "word" : "car",
                "translate" : "машина"
                }
                """;
    }

    default String requestBodeWithAddSun() {
        return """
                {
                "word" : "sun",
                "translate" : "солнце"
                }
                """;
    }

    default String requestBodeWithAddDog() {
        return """
                {
                "word" : "dog",
                "translate" : "собака"
                }
                """;
    }

    default String requestBodyLogin() {
        return """
                {
                  "email": "ru@ru",
                  "password": "12345678"
                }
                """.trim();
    }

    default String requestBodyRegister() {
        return """
                {
                  "username": "Maksim",
                  "surname": "Abramovich",
                  "language": "RU",
                  "email": "ru@ru",
                  "password": "12345678"
                }
                """.trim();
    }

    default AnswerResultDto answerQuestion(MockMvc mockMvc, ObjectMapper objectMapper, String authHeader, long questionId, String answer) throws Exception {
        MvcResult result = mockMvc.perform(post("/dailytest/questions/{id}/answer", questionId)
                        .header("Authorization", "Bearer " + authHeader)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                    { "userAnswer": "%s" }
                                """.formatted(answer)))
                .andExpect(status().isOk())
                .andReturn();
        return objectMapper.readValue(result.getResponse().getContentAsString(), AnswerResultDto.class);
    }
}