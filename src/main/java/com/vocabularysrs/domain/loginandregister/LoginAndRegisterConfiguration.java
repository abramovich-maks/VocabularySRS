package com.vocabularysrs.domain.loginandregister;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class LoginAndRegisterConfiguration {

    @Bean
    LoginAndRegisterFacade loginAndRegisterFacade(UserRepository userRepository, PasswordEncoder encodedPassword) {
        UserRetriever userRetriever = new UserRetriever(userRepository);
        UserAdder userAdder = new UserAdder(userRepository, userRetriever, encodedPassword);
        return new LoginAndRegisterFacade(userAdder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
