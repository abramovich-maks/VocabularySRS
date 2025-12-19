package com.vocabularysrs.feature;

import com.vocabularysrs.BaseIntegrationTest;

class UserAddWordsAndCompleteDailyTest extends BaseIntegrationTest {

//    step 1: user made GET /words and sees 0 words.
//    step 2: user made POST /words with body (word: cat, translate: кот) at 19-12-2025 12:00, and the system returned OK (200) with message: "Success. New word added" and word: "cat", translate: "кот".
//    step 3: user made GET /words and sees 1 word.
//    step 4: user made POST /words with body (word: dog, translate: собака) at 19-12-2025 13:00, and the system returned OK (200) with message: "Success. New word added" and word: "dog", translate: "собака".
//    step 5: user made POST /words with body (word: sun, translate: солнце) at 19-12-2025 14:00, and the system returned OK (200) with message: "Success. New word added" and word: "sun", translate: "солнце".
//    step 6: user made POST /words with body (word: car, translate: машина) at 19-12-2025 15:00, and the system returned OK (200) with message: "Success. New word added" and word: "car", translate: "машина".
//    step 7: user made GET /words and sees 4 words.
//    step 8: user made GET /words/2, and the system returned id: "2", word: "dog", translate: "собака".
//    step 9: user made DELETE /words/3, and the system deleted the word with id 3 and returned the message: "Deleted word by id: 2".
//    step 10: 15 hours and 1 minute passed (20.12.2025 06:01).
//    step 11: the system at 6:00 selected words for the user (3 words).
//    step 12: the system at 6:05 generated a task with selected words for the date 20.12.2025.
//    step 13: user made POST /dailytest and requested 1 true and 2 false questions, and the server returned test statistics.
//    step 14: 1 day passed (21.12.2025 06:01).
//    step 15: the system at 6:00 selected words for the user (2 words).
//    step 16: the system at 6:05 generated a task with selected words for the date 21.12.2025.
//    step 17: user made POST /dailytest and requested 2 true questions, and the server returned test statistics.
//    step 18: 2 days passed (23.12.2025 06:01).
//    step 19: the system at 6:00 selected words for the user (1 word).
//    step 20: the system at 6:05 generated a task with selected words for the date 23.12.2025.

}
