package com.vocabularysrs;

import com.vocabularysrs.infrastructure.dictionary.http.DictionaryRestTemplateConfigurationProperties;
import com.vocabularysrs.infrastructure.security.jwt.vocabulary.JwtConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JwtConfigurationProperties.class, DictionaryRestTemplateConfigurationProperties.class})
public class VocabularySrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VocabularySrsApplication.class, args);
    }

}
