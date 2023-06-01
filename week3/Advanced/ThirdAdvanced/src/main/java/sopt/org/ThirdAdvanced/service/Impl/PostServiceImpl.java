package sopt.org.ThirdAdvanced.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdAdvanced.controller.dto.request.PostUploadDto;
import sopt.org.ThirdAdvanced.controller.dto.response.PostResponseDto;
import sopt.org.ThirdAdvanced.domain.Post;
import sopt.org.ThirdAdvanced.domain.User;
import sopt.org.ThirdAdvanced.exception.CustomException;
import sopt.org.ThirdAdvanced.infrastructure.PostRepository;
import sopt.org.ThirdAdvanced.infrastructure.UserRepository;
import sopt.org.ThirdAdvanced.response.FailStatus;
import sopt.org.ThirdAdvanced.service.PostService;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void uploadPost(PostUploadDto postUploadDto) {
        User findUser = findByUser(postUploadDto.getUserId());

        Post newPost = Post.builder()
                .user(findUser)
                .title(postUploadDto.getTitle())
                .content(postUploadDto.getContent())
                .build();

        postRepository.save(newPost);
    }

    @Override
    @Transactional
    public PostResponseDto getPostById(Long postId) {
        Post findPost = postRepository.findById(postId).orElseThrow(() -> new CustomException(FailStatus.NOT_FOUND_POST_EXCEPTION));

        return PostResponseDto.of(findPost);
    }

    private User findByUser(Long userId) {
        User findUser = userRepository.findById(userId).orElseThrow(() -> new CustomException(FailStatus.NOT_FOUND_USER_EXCEPTION));
        return findUser;
    }
}
