package com.vocabularysrs.domain.loginandregister;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class LoginAndRegisterConfiguration {

    @Bean
    LoginAndRegisterFacade loginAndRegisterFacade(UserRepository userRepository, PasswordEncoder encodedPassword, JavaMailSender mailSender, MailSenderProperties mailProperties) {
        UserRetriever userRetriever = new UserRetriever(userRepository);
        UserConformer userConformer = new UserConformer(mailSender, userRepository, mailProperties);
        UserAdder userAdder = new UserAdder(userRepository, userRetriever, encodedPassword, userConformer);
        return new LoginAndRegisterFacade(userAdder, userRetriever, userConformer);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
