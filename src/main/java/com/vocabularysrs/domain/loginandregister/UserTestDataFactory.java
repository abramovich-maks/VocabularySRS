package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.shared.Language;

public class UserTestDataFactory {

    public static User createTestUser(Long id) {
        User user = User.createNew(
                "test",
                "test",
                Language.RU,
                "test@email.com",
                "password",
                null
        );
        user.setId(id);
        user.setEnabled(true);
        return user;
    }
}
