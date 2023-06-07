package sopt.org.SixthSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.SixthSeminar.common.dto.ApiResponse;
import sopt.org.SixthSeminar.config.jwt.JwtService;
import sopt.org.SixthSeminar.config.resolver.UserId;
import sopt.org.SixthSeminar.controller.dto.request.BoardFileListDto;
import sopt.org.SixthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.SixthSeminar.exception.Error;
import sopt.org.SixthSeminar.exception.Success;
import sopt.org.SixthSeminar.external.aws.S3Service;
import sopt.org.SixthSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@SecurityRequirement(name = "JWT Auth")
public class BoardController {

    private final BoardService boardService;
    private final S3Service s3Service;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardRequestDto request) {
        String boardThumbnailImageUrl = s3Service.uploadImage(request.getThumbnail(), "board");
        boardService.create(userId, boardThumbnailImageUrl, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }

    @PostMapping(value = "/create/all", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createList(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardFileListDto request) {
        List<String> boardThumbnailImageUrls = s3Service.uploadImages(request.getImageList(), "board");
        boardService.createList(userId, boardThumbnailImageUrls, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
