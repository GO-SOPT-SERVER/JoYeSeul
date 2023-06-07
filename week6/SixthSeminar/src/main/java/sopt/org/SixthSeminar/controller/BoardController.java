package sopt.org.SixthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.SixthSeminar.common.dto.ApiResponse;
import sopt.org.SixthSeminar.config.jwt.JwtService;
import sopt.org.SixthSeminar.config.resolver.UserId;
import sopt.org.SixthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.SixthSeminar.exception.Error;
import sopt.org.SixthSeminar.exception.Success;
import sopt.org.SixthSeminar.service.BoardService;

import javax.validation.Valid;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(@UserId Long userId, @RequestBody @Valid BoardRequestDto request) {
        boardService.create(userId, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
