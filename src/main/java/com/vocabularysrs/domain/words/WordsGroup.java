package com.vocabularysrs.domain.words;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.vocabularysrs.infrastructure.api.validation.ValidationConstants.GROUP_NAME_SIZE;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
class WordsGroup {

    @Id
    @GeneratedValue(generator = "group_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "group_id_seq",
            sequenceName = "group_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @NotNull
    @Size(max = GROUP_NAME_SIZE)
    private String groupName;
}
