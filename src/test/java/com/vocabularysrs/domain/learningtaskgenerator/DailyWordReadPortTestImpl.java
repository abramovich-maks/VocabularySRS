//package com.vocabularysrs.domain.learningtaskgenerator;
//
//import com.vocabularysrs.domain.dailywordsselector.DailyWordSnapshot;
//import com.vocabularysrs.domain.dailywordsselector.DailyWordSnapshotTestFactory;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public class DailyWordReadPortTestImpl implements DailyWordReadPort {
//
//    @Override
//    public List<DailyWordSnapshot> findDailyWordReviewByTaskDate(LocalDate today) {
//        LocalDate now = LocalDate.now();
//        return List.of(
//                DailyWordSnapshotTestFactory.withSingleWord(
//                        1L,
//                        now,
//                        "cat",
//                        "кот"
//                )
//        );
//    }
//}