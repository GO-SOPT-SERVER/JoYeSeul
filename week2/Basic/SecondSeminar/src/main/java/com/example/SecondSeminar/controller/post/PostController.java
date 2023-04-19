package com.example.SecondSeminar.controller.post;

import com.example.SecondSeminar.controller.post.dto.request.PostRequestDto;
import com.example.SecondSeminar.domain.Post;
import com.example.SecondSeminar.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.example.SecondSeminar.SecondSeminarApplication.postList;
import static com.example.SecondSeminar.SecondSeminarApplication.userList;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //* 게시물 생성
    @PostMapping("/post")
    public String register(@RequestBody PostRequestDto request) {
        Long postId = postService.register(request);
        return postId + "번 게시물이 등록되었습니다!";
    }

    //* 게시물 조회 - 아이디로 조회
    @GetMapping("/post/{postId}")
    public String getByPostId(@PathVariable final Long postId) {
        try {
            Post getPost = postService.findById(postId);
            System.out.println(getPost.toString());

            return "===========" + getPost.getId() + "번 게시물 조회 성공"
                    + "===========\n" + getPost.toString();

        } catch (Exception e) {
            return "해당 id 값의 게시물이 존재하지 않습니다.";
        }
    }

    //* 게시물 검색 - 해당 제목의 게시물 검색
    @GetMapping("/post/search")
    public String getByPostTitle(@RequestParam final String title) {
        Post getPost = postService.findByTitle(title);
        if (getPost == null) {
            return "해당 제목의 게시물이 존재하지 않습니다.";
        }
        return "=========== 제목 : " + getPost.getTitle() + " 게시물 조회 성공"
                + "===========\n" + getPost.toString();
    }
}
