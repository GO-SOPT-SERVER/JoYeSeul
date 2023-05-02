package com.example.ThirdSeminar.controller;

import com.example.ThirdSeminar.common.dto.ApiResponseDto;
import com.example.ThirdSeminar.controller.dto.user.request.UserRequestDto;
import com.example.ThirdSeminar.controller.dto.user.response.UserResponseDto;
import com.example.ThirdSeminar.exception.SuccessStatus;
import com.example.ThirdSeminar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody @Valid final UserRequestDto requestDto) {
        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(requestDto));
    }

}
