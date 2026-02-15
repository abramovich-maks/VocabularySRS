package com.vocabularysrs;

import com.vocabularysrs.infrastructure.dictionary.http.DictionaryRestTemplateConfigurationProperties;
import com.vocabularysrs.infrastructure.security.jwt.vocabulary.JwtConfigurationProperties;
import com.vocabularysrs.infrastructure.translation.http.TranslateClientConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties({JwtConfigurationProperties.class, DictionaryRestTemplateConfigurationProperties.class, TranslateClientConfigurationProperties.class})
@EnableCaching
public class VocabularySrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VocabularySrsApplication.class, args);
    }

}
