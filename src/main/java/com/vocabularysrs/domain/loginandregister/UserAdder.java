package com.vocabularysrs.domain.loginandregister;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.vocabularysrs.domain.loginandregister.UserMapper.mapFromUserToUserRegisterResponseDto;

@AllArgsConstructor
@Log4j2
class UserAdder {

    private final UserRepository userRepository;
    private final UserRetriever userRetriever;
    private final PasswordEncoder bCryptpasswordEncoder;

    UserRegisterResponseDto addUser(final UserRegisterRequestDto requestDto) {
        boolean emailExists = userRetriever.existsByEmail(requestDto.email());
        if (emailExists) {
            throw new UserAlreadyExistException(requestDto.email());
        }
        String encodedPassword = bCryptpasswordEncoder.encode(requestDto.password());
        User createdUser = User.createNew(requestDto.username(), requestDto.surname(), requestDto.email(), encodedPassword);
        User savedUser = userRepository.save(createdUser);
        log.info("Saved user with id: {}, email: {}", savedUser.getId(), savedUser.getEmail());
        return mapFromUserToUserRegisterResponseDto(savedUser);
    }
}

