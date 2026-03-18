package com.vocabularysrs.domain.loginandregister;

import com.vocabularysrs.domain.loginandregister.dto.UserRegisterRequestDto;
import com.vocabularysrs.domain.loginandregister.dto.UserRegisterResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static com.vocabularysrs.domain.loginandregister.UserMapper.mapFromUserToUserRegisterResponseDto;

@AllArgsConstructor
@Log4j2
class UserAdder {

    private final UserRepository userRepository;
    private final UserRetriever userRetriever;
    private final PasswordEncoder bCryptpasswordEncoder;
    private final UserConformer userConformer;

    UserRegisterResponseDto addUser(final UserRegisterRequestDto requestDto) {
        String email = requestDto.email().trim().toLowerCase();
        userRetriever.existsByEmail(email);
        String confirmationToken = UUID.randomUUID().toString();
        String encodedPassword = bCryptpasswordEncoder.encode(requestDto.password());
        User createdUser = User.createNew(requestDto.username(), requestDto.surname(), requestDto.language(), email, encodedPassword, confirmationToken);
        User savedUser = userRepository.save(createdUser);
        log.info("Saved user with id: {}, email: {}", savedUser.getId(), savedUser.getEmail());
        userConformer.sendConfirmationEmail(createdUser);
        return mapFromUserToUserRegisterResponseDto(savedUser);
    }
}

