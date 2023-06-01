package sopt.org.ThirdAdvanced.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentUploadDto {
    @NotNull
    private Long userId;

    @NotNull
    private Long postId;

    @NotBlank
    private String content;
}
