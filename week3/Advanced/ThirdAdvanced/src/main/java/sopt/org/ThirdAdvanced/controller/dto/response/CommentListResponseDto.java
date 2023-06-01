package sopt.org.ThirdAdvanced.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.ThirdAdvanced.domain.Comment;
import sopt.org.ThirdAdvanced.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentListResponseDto {

    private PostResponseDto post;
    private List<CommentResponseDto> commentList = new ArrayList<>();

    public static CommentListResponseDto of (Post post, List<Comment> comments) {
        PostResponseDto postDto = PostResponseDto.of(post);
        List<CommentResponseDto> commentDtos = comments.stream()
                .map(CommentResponseDto::of)
                .collect(Collectors.toList());

        return new CommentListResponseDto(postDto, commentDtos);

    }
}
