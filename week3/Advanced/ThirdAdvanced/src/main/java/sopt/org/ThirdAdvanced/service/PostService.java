package sopt.org.ThirdAdvanced.service;

import sopt.org.ThirdAdvanced.controller.dto.request.PostUploadDto;
import sopt.org.ThirdAdvanced.controller.dto.response.PostResponseDto;
import sopt.org.ThirdAdvanced.domain.Post;

public interface PostService {

    //* 게시물 생성
    void uploadPost(PostUploadDto postUploadDto);

    //* 게시물 조회
    PostResponseDto getPostById(Long postId);
}
