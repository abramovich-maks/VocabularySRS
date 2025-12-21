package com.vocabularysrs.infrastructure.clock;

import com.vocabularysrs.domain.AdjustableClock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.ZoneId;

@Configuration
class ClockConfig {

    @Bean
    AdjustableClock clock() {
        return new AdjustableClock(Instant.now(), ZoneId.systemDefault());
    }
}
