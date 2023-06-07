package sopt.org.SixthSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSignUpResponseDto {
    private Long userId;
    private String nickname;

    public static UserSignUpResponseDto of (Long userId, String nickname) {
        return new UserSignUpResponseDto(userId, nickname);
    }
}
