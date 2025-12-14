package com.vocabularysrs.domain.loginandregister;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginAndRegisterFacadeTest {

    UserRepository userRepository = new InMemoryUserRepository();
    PasswordEncoder encodedPassword = new LoginAndRegisterConfiguration().passwordEncoder();
    LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterConfiguration().loginAndRegisterFacade(userRepository, encodedPassword);

    @Test
    public void should_return_success_when_user_email_is_not_exist() {
        // given
        UserRegisterRequestDto newUserRequest = UserRegisterRequestDto.builder()
                .username("Maksim")
                .surname("Abramovich")
                .email("email@mail.com")
                .password("12345678")
                .build();
        // when
        UserRegisterResponseDto registerResult = loginAndRegisterFacade.registerUser(newUserRequest);
        // then
        assertAll(
                () -> assertThat(registerResult.message()).isEqualTo("User created successful!"),
                () -> assertThat(registerResult.username()).isEqualTo("Maksim"),
                () -> assertThat(registerResult.surname()).isEqualTo("Abramovich"),
                () -> assertThat(registerResult.email()).isEqualTo("email@mail.com")
        );
    }

    @Test
    public void should_throw_an_exception_when_user_email_already_exist() {
        // given
        UserRegisterRequestDto newUserRequest = UserRegisterRequestDto.builder()
                .username("Maksim")
                .surname("Abramovich")
                .email("email@mail.com")
                .password("12345678")
                .build();
        loginAndRegisterFacade.registerUser(newUserRequest);
        // when
        UserAlreadyExistException userAlreadyExistException = assertThrows(UserAlreadyExistException.class, () -> loginAndRegisterFacade.registerUser(newUserRequest));
        // then
        assertThat(userAlreadyExistException.getMessage()).isEqualTo("User with email [ " + newUserRequest.email() + " ] already exists");
    }

    @Test
    public void should_encode_password_when_user_created() {
        // given
        UserRegisterRequestDto newUserRequest = UserRegisterRequestDto.builder()
                .username("Maksim")
                .surname("Abramovich")
                .email("email@mail.com")
                .password("12345678")
                .build();
        // when
        loginAndRegisterFacade.registerUser(newUserRequest);
        User createdUser = ((InMemoryUserRepository) userRepository).findByEmail(newUserRequest.email());
        // then
        assertThat(createdUser.getPasswordHash()).isNotNull();
        assertThat(createdUser.getPasswordHash()).isNotEqualTo(newUserRequest.password());
        assertThat(encodedPassword.matches(newUserRequest.password(), createdUser.getPasswordHash())).isTrue();
    }
}