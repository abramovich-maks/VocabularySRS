package com.vocabularysrs;

import com.vocabularysrs.domain.AdjustableClock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Configuration
@Profile("integration")
class IntegrationConfiguration {

    @Bean
    @Primary
    AdjustableClock testClock() {
        return AdjustableClock.ofLocalDateAndLocalTime(
                LocalDate.of(2025, 12, 19),
                LocalTime.of(12, 0),
                ZoneId.systemDefault());
    }
}

