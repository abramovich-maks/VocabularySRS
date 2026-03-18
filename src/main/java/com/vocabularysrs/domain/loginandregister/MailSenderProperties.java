package com.vocabularysrs.domain.loginandregister;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.email.confirmation")
public record MailSenderProperties(
        String baseUrl,
        String mailFrom
        ) {
}


