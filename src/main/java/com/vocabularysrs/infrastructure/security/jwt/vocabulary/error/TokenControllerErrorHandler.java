package com.vocabularysrs.infrastructure.security.jwt.vocabulary.error;


import com.vocabularysrs.domain.loginandregister.UserAlreadyExistException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
class TokenControllerErrorHandler {

    private static final String BAD_CREDENTIALS = "Invalid email or password";
    private static final String EMAIL_ALREADY_EXISTS = "Email is already registered";

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public LoginErrorResponse handleBadCredentials() {
        return new LoginErrorResponse(BAD_CREDENTIALS, HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseBody
    public LoginErrorResponse mailDuplicate(UserAlreadyExistException duplicateMailException) {
        log.warn("User registration failed: email already exists [{}]", duplicateMailException.userEmail);
        return new LoginErrorResponse(EMAIL_ALREADY_EXISTS, HttpStatus.CONFLICT);
    }
}
