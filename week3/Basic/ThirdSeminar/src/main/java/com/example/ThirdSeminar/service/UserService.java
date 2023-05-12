package com.example.ThirdSeminar.service;

import com.example.ThirdSeminar.controller.dto.user.request.UserRequestDto;
import com.example.ThirdSeminar.controller.dto.user.response.UserResponseDto;
import com.example.ThirdSeminar.domain.User;
import com.example.ThirdSeminar.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto requestDto) {
        User user = User.builder()
                .email(requestDto.getEmail())
                .nickname(requestDto.getNickname())
                .password(requestDto.getPassword())
                .build();

        userRepository.save(user);
        return UserResponseDto.of(user.getId(), user.getNickname());
    }
}
