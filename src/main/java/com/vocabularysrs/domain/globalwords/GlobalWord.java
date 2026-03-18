package com.vocabularysrs.domain.globalwords;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
public class GlobalWord {

    @Id
    @GeneratedValue(generator = "global_words_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "global_words_id_seq",
            sequenceName = "global_words_id_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    private String word;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WordExample> wordExamples = new ArrayList<>();
}
