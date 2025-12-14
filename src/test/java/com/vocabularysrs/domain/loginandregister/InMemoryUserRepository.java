package com.vocabularysrs.domain.loginandregister;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryUserRepository implements UserRepository {

    private final Map<Long, User> database = new ConcurrentHashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public boolean existsByEmail(final String email) {
        for (User user : database.values()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User save(final User user) {
        long index = this.index.getAndIncrement();
        database.put(index, user);
        user.setId(index);
        return user;
    }

    public User findByEmail(final String email) {
        return database.values().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
