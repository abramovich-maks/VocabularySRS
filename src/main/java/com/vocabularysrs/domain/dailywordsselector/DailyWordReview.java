//package com.vocabularysrs.domain.dailywordsselector;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.SequenceGenerator;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter(AccessLevel.PACKAGE)
//@Setter(AccessLevel.PACKAGE)
//@Entity
//class DailyWordReview {
//    @Id
//    @GeneratedValue(generator = "daily_word_review_id_seq", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(
//            name = "daily_word_review_id_seq",
//            sequenceName = "daily_word_review_id_seq",
//            allocationSize = 1
//    )
//    private Long id;
//
//    @Column(nullable = false)
//    private Long userId;
//
//    @Column(nullable = false)
//    private LocalDate taskDate;
//
//    @OneToMany(mappedBy = "dailyWordReview", cascade = CascadeType.ALL)
//    private List<ReviewWordItem> items = new ArrayList<>();
//
//    public void addItem(ReviewWordItem item) {
//        this.items.add(item);
//        item.setDailyWordReview(this);
//    }
//}
