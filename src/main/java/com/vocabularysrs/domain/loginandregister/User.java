package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.shared.Language;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "users_id_seq",
            sequenceName = "users_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_language", nullable = false)
    private Language language;

    private String confirmationToken;

    private boolean enabled = false;

    public boolean confirm() {
        this.setEnabled(true);
        this.setConfirmationToken(null);
        return true;
    }

    static User createNew(final String username, final String surname, final Language language, final String email, final String passwordHash, final String confirmationToken) {
        return User.builder()
                .username(username)
                .surname(surname)
                .language(language)
                .email(email)
                .passwordHash(passwordHash)
                .confirmationToken(confirmationToken)
                .build();
    }
}
