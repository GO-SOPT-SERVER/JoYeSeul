package sopt.org.ThirdAdvanced.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdAdvanced.common.dto.ApiResponse;
import sopt.org.ThirdAdvanced.controller.dto.request.UserSignUpDto;
import sopt.org.ThirdAdvanced.response.SuccessStatus;
import sopt.org.ThirdAdvanced.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse signup(@RequestBody @Valid final UserSignUpDto request) {
        userService.signUp(request);
        return ApiResponse.success(SuccessStatus.SIGNUP_SUCCESS);
    }
}
