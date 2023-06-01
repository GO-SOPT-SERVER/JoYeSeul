package sopt.org.ThirdAdvanced.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE) //requestDto는 클라이언트에게 받은 그대로를 가져와야하므로 다른 곳에서 생성되지 않도록 접근 제어 private
public class PostUploadDto {

    @NotNull // NotBlank로 걸면 " "(공백) 검사까지 해야하는데 타입이 String이 아니라 Long이므로 에러남 !
    private Long userId; // 현재는 토큰 개념이 없으므로 클라이언트가 해당 유저 Id를 직접 보내준다고 가정

    @NotBlank
    private String title;

    private String content;
}
