package sopt.org.ThirdAdvanced.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdAdvanced.controller.dto.request.CommentUploadDto;
import sopt.org.ThirdAdvanced.controller.dto.response.CommentListResponseDto;
import sopt.org.ThirdAdvanced.domain.Comment;
import sopt.org.ThirdAdvanced.domain.Post;
import sopt.org.ThirdAdvanced.domain.User;
import sopt.org.ThirdAdvanced.exception.CustomException;
import sopt.org.ThirdAdvanced.infrastructure.CommentRepository;
import sopt.org.ThirdAdvanced.infrastructure.PostRepository;
import sopt.org.ThirdAdvanced.infrastructure.UserRepository;
import sopt.org.ThirdAdvanced.response.FailStatus;
import sopt.org.ThirdAdvanced.service.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public void uploadComment(CommentUploadDto commentUploadDto) {
        User user = findUser(commentUploadDto.getUserId());
        Post post = findPost(commentUploadDto.getPostId());

        Comment newComment = Comment.builder()
                .user(user)
                .post(post)
                .content(commentUploadDto.getContent())
                .build();

        commentRepository.save(newComment);
    }

    @Override
    @Transactional
    public CommentListResponseDto getCommentsByPostId(Long postId) {
        Post post = findPost(postId);
        List<Comment> byPostId = commentRepository.findByPostId(postId);
        return CommentListResponseDto.of(post, byPostId);
    }

    private User findUser(Long userId) {
        User findUser = userRepository.findById(userId).orElseThrow(() -> new CustomException(FailStatus.NOT_FOUND_USER_EXCEPTION));
        return findUser;
    }

    private Post findPost(Long postId) {
        Post findPost = postRepository.findById(postId).orElseThrow(() -> new CustomException(FailStatus.NOT_FOUND_POST_EXCEPTION));
        return findPost;
    }
}
