package com.vocabularysrs.domain.loginandregister;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.InputStream;

class InMemoryMailSender implements JavaMailSender {

    @Override
    public void send(SimpleMailMessage simpleMessage) {

    }

    @Override
    public void send(final SimpleMailMessage... simpleMessages) throws MailException {

    }

    @Override
    public MimeMessage createMimeMessage() {
        return null;
    }

    @Override
    public MimeMessage createMimeMessage(final InputStream contentStream) throws MailException {
        return null;
    }

    @Override
    public void send(final MimeMessage... mimeMessages) throws MailException {

    }
}