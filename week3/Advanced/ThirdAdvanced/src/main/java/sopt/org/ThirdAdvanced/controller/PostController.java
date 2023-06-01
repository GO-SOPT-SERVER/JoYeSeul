package sopt.org.ThirdAdvanced.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdAdvanced.common.dto.ApiResponse;
import sopt.org.ThirdAdvanced.controller.dto.request.PostUploadDto;
import sopt.org.ThirdAdvanced.controller.dto.request.UserSignUpDto;
import sopt.org.ThirdAdvanced.controller.dto.response.PostResponseDto;
import sopt.org.ThirdAdvanced.domain.Post;
import sopt.org.ThirdAdvanced.response.SuccessStatus;
import sopt.org.ThirdAdvanced.service.PostService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse uploadPost(@RequestBody @Valid final PostUploadDto request) {
        postService.uploadPost(request);
        return ApiResponse.success(SuccessStatus.CREATE_POST_SUCCESS);
    }

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PostResponseDto> getPostById(@PathVariable final Long postId) {
        PostResponseDto findPost = postService.getPostById(postId);
        return ApiResponse.success(SuccessStatus.READ_POST_SUCCESS, findPost);
    }
}
