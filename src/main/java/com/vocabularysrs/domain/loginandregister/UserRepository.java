package com.vocabularysrs.domain.loginandregister;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface UserRepository extends Repository<User, Long> {

    boolean existsByEmail(String email);

    User save(User user);

    Optional<User> findByEmail(String email);
}
