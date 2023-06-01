package sopt.org.ThirdAdvanced.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.ThirdAdvanced.domain.Post;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostResponseDto of(Post findPost) {
        return new PostResponseDto(findPost.getId(), findPost.getUser().getNickname(), findPost.getTitle()
                , findPost.getContent(), findPost.getCreatedAt(), findPost.getModifiedAt());
    }
}
