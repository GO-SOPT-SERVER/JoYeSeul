package sopt.org.SixthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.SixthSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.SixthSeminar.controller.dto.request.UserSingUpRequestDto;
import sopt.org.SixthSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.SixthSeminar.controller.dto.response.UserSignUpResponseDto;
import sopt.org.SixthSeminar.domain.User;
import sopt.org.SixthSeminar.exception.Error;
import sopt.org.SixthSeminar.exception.model.BadRequestException;
import sopt.org.SixthSeminar.exception.model.ConflictException;
import sopt.org.SixthSeminar.exception.model.NotFoundException;
import sopt.org.SixthSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long login(UserLoginRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        if (!user.getPassword().equals(requestDto.getPassword())) {
            throw new BadRequestException(Error.INVALID_PASSWORD_EXCEPTION, Error.INVALID_PASSWORD_EXCEPTION.getMessage());
        }

        return user.getId();
    }

    @Transactional
    public UserSignUpResponseDto create(UserSingUpRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException(Error.ALREADY_EXIST_USER_EXCEPTION, Error.ALREADY_EXIST_USER_EXCEPTION.getMessage());
        }

        User newUser = User.newInstance(
                request.getNickname(),
                request.getEmail(),
                request.getPassword()
        );

        userRepository.save(newUser);

        return UserSignUpResponseDto.of(newUser.getId(), newUser.getNickname());
    }
}
