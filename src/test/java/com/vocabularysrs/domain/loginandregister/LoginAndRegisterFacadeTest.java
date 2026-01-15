package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.loginandregister.dto.UserRegisterRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginAndRegisterFacadeTest {

    UserRepository userRepository = new InMemoryUserRepository();
    PasswordEncoder encodedPassword = new InMemoryPasswordEncoder();
    LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterConfiguration().loginAndRegisterFacade(userRepository, encodedPassword);

    @Test
    public void should_return_success_when_user_register_with_not_exist_email() {
        // given
        String email = "email@mail.com";
        String password = "12345678";
        UserRegisterRequestDto newUserRequest = UserRegisterRequestDto.builder()
                .username("Maksim")
                .surname("Abramovich")
                .language(UserLanguage.RU)
                .email(email)
                .password(password)
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
    public void should_throw_an_exception_when_user_register_with_exist_email() {
        // given
        String email = "email@mail.com";
        String password = "12345678";
        UserRegisterRequestDto newUserRequest = UserRegisterRequestDto.builder()
                .username("Maksim")
                .surname("Abramovich")
                .language(UserLanguage.RU)
                .email(email)
                .password(password)
                .build();
        loginAndRegisterFacade.registerUser(newUserRequest);
        // when
        UserAlreadyExistException userAlreadyExistException = assertThrows(UserAlreadyExistException.class, () -> loginAndRegisterFacade.registerUser(newUserRequest));
        // then
        assertThat(userAlreadyExistException.getMessage()).isEqualTo("User with email [ " + newUserRequest.email() + " ] already exists");
    }

    @Test
    public void should_encode_password_when_user_register() {
        // given
        String email = "email@mail.com";
        String password = "12345678";
        UserRegisterRequestDto newUserRequest = UserRegisterRequestDto.builder()
                .username("Maksim")
                .surname("Abramovich")
                .language(UserLanguage.RU)
                .email(email)
                .password(password)
                .build();
        // when
        loginAndRegisterFacade.registerUser(newUserRequest);
        UserDtoResponse createdUser = loginAndRegisterFacade.findByEmail(newUserRequest.email());
        // then
        assertThat(createdUser.password()).isNotNull();
        assertThat(createdUser.password()).isNotEqualTo(newUserRequest.password());
        assertThat(encodedPassword.matches(newUserRequest.password(), createdUser.password())).isTrue();
    }
}