package sopt.org.SixthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.SixthSeminar.common.dto.ApiResponse;
import sopt.org.SixthSeminar.config.jwt.JwtService;
import sopt.org.SixthSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.SixthSeminar.controller.dto.request.UserSingUpRequestDto;
import sopt.org.SixthSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.SixthSeminar.controller.dto.response.UserSignUpResponseDto;
import sopt.org.SixthSeminar.exception.Success;
import sopt.org.SixthSeminar.service.UserService;


import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserSignUpResponseDto> create(@RequestBody @Valid final UserSingUpRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request);
        final String token = jwtService.issuedToken(String.valueOf(userId));
        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, token));
    }
}
