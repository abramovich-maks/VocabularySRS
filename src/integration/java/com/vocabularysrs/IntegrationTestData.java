package com.vocabularysrs;

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

    default String getRequestWithOneTrueAnswerCat() {
        return """
                {
                  "answers": [
                    {"questionId": 1, "answer": "кот"},
                    {"questionId": 2, "answer": "cat"},
                    {"questionId": 3, "answer": "false"},
                    {"questionId": 4, "answer": "false"},
                    {"questionId": 5, "answer": "false"},
                    {"questionId": 6, "answer": "false"}
                  ]
                }
                """;
    }

    default String getRequestWithTrueAnswersDogAndCar() {
        return """
                {
                  "answers": [
                    {"questionId": 7, "answer": "собака"},
                    {"questionId": 8, "answer": "dog"},
                    {"questionId": 9, "answer": "машина"},
                    {"questionId": 10, "answer": "car"}
                  ]
                }
                """;
    }

    default String getRequestWithAllTrueQuestions() {
        return """
                {
                  "answers": [
                    {"questionId": 11, "answer": "кот"},
                    {"questionId": 12, "answer": "cat"},
                    {"questionId": 13, "answer": "собака"},
                    {"questionId": 14, "answer": "dog"},
                    {"questionId": 15, "answer": "машина"},
                    {"questionId": 16, "answer": "car"}
                  ]
                }
                """;
    }
}
