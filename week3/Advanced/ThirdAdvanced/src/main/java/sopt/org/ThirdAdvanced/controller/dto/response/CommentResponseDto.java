package sopt.org.ThirdAdvanced.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.ThirdAdvanced.domain.Comment;
import sopt.org.ThirdAdvanced.domain.Post;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentResponseDto {

    private Long id;
    private String authorNickname;
    private String authorEmail;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentResponseDto of (Comment comment) {
        return new CommentResponseDto(comment.getId(), comment.getUser().getNickname(), comment.getUser().getEmail()
                ,comment.getContent(), comment.getCreatedAt(), comment.getModifiedAt());
    }
}
