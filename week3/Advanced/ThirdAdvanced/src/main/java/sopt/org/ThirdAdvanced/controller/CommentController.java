package sopt.org.ThirdAdvanced.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdAdvanced.common.dto.ApiResponse;
import sopt.org.ThirdAdvanced.controller.dto.request.CommentUploadDto;
import sopt.org.ThirdAdvanced.controller.dto.response.CommentListResponseDto;
import sopt.org.ThirdAdvanced.controller.dto.response.CommentResponseDto;
import sopt.org.ThirdAdvanced.response.SuccessStatus;
import sopt.org.ThirdAdvanced.service.CommentService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse uploadComment(@RequestBody @Valid final CommentUploadDto request){
        commentService.uploadComment(request);
        return ApiResponse.success(SuccessStatus.CREATE_COMMENT_SUCCESS);
    }

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<CommentListResponseDto> getCommentByPostId(@PathVariable final Long postId) {
        CommentListResponseDto commentsByPostId = commentService.getCommentsByPostId(postId);
        return ApiResponse.success(SuccessStatus.READ_COMMENT_SUCCESS, commentsByPostId);
    }
}
