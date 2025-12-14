package com.vocabularysrs.domain.loginandregister;

import org.springframework.data.repository.Repository;

interface UserRepository extends Repository<User, Long> {

    boolean existsByEmail(String email);

    User save(User user);
}
