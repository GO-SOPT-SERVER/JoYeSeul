package sopt.org.ThirdAdvanced.service;

import sopt.org.ThirdAdvanced.controller.dto.request.CommentUploadDto;
import sopt.org.ThirdAdvanced.controller.dto.response.CommentListResponseDto;

public interface CommentService {
    //* 특정 게시물의 댓글 생성
    void uploadComment(CommentUploadDto commentUploadDto);

    //* 특정 게시물의 댓글들 조회
    CommentListResponseDto getCommentsByPostId(Long postId);
}
