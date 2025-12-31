//package com.vocabularysrs.domain.dailywordsselector;
//
//import com.vocabularysrs.domain.AdjustableClock;
//import com.vocabularysrs.domain.dictionary.WordEntryReadPort;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.ZoneId;
//import java.util.Collection;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//class TaskCreatorFacadeTest {
//
//    AdjustableClock clock = AdjustableClock.ofLocalDateAndLocalTime(
//            LocalDate.of(2025, 1, 1),
//            LocalTime.of(12, 0),
//            ZoneId.systemDefault()
//    );
//
//    WordEntryReadPort wordEntryReadPort = new WordEntryReadPortTestImpl();
//    InMemoryDailyWordRepositoryTestImpl dailyWordRepository = new InMemoryDailyWordRepositoryTestImpl();
//    DailyWordsSelectorFacade dailyWordsSelectorFacade = new DailyWordsSelectorConfiguration().dailyWordsSelector(wordEntryReadPort, dailyWordRepository, clock);
//    LocalDate today = clock.today();
//
//    @Test
//    public void should_create_daily_reviews_for_multiple_users_when_words_are_available() {
//        // given
//        wordEntryReadPort.findWordEntriesByNextReviewDateLessThanEqual(today);
//        // when
//        dailyWordsSelectorFacade.retrieveWordsByDate();
//        // then
//        Collection<DailyWordReview> reviews = dailyWordRepository.findAll();
//        assertEquals(2, reviews.size());
//
//        DailyWordReview user1Review =
//                reviews.stream().filter(user -> user.getUserId() == 1L).findFirst().orElseThrow();
//        assertEquals(2, user1Review.getItems().size());
//
//        DailyWordReview user2Review =
//                reviews.stream().filter(user -> user.getUserId() == 2L).findFirst().orElseThrow();
//        assertEquals(1, user2Review.getItems().size());
//    }
//
//    @Test
//    void should_do_nothing_when_no_words_are_found_for_today() {
//        // given
//        WordEntryReadPortTestImpl wordEntryReadPort = new WordEntryReadPortTestImpl();
//        InMemoryDailyWordRepositoryTestImpl repository = new InMemoryDailyWordRepositoryTestImpl();
//        wordEntryReadPort.findWordEntriesByNextReviewDateLessThanEqual(today);
//        // when
//        dailyWordsSelectorFacade.retrieveWordsByDate();
//        // then
//        assertTrue(repository.findAll().isEmpty());
//    }
//
//}