package com.vocabularysrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class VocabularySrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VocabularySrsApplication.class, args);
    }

}
