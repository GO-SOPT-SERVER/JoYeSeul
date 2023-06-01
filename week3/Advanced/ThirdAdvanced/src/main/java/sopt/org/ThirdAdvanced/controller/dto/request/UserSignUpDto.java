package sopt.org.ThirdAdvanced.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSignUpDto {
    @Email(message = "이메일 형식에 맞지 않습니다")
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "닉네임 형식에 맞지 않습니다")
    private String nickname;

    @NotBlank
    @Pattern(
            regexp="^\\d{3}-\\d{3,4}-\\d{4}$",
            message = "올바른 핸드폰 번호 형식이어야 합니다"
    )
    private String phoneNumber;
}
