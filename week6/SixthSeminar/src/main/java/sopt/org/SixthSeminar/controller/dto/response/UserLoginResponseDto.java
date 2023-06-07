package sopt.org.SixthSeminar.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class UserLoginResponseDto {
    private Long userId;
    private String accessToken;

    public static UserLoginResponseDto of (Long userId, String accessToken) {
        return new UserLoginResponseDto(userId, accessToken);
    }
}
