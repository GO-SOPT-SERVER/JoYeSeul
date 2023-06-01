package sopt.org.ThirdAdvanced.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sopt.org.ThirdAdvanced.response.FailStatus;
import sopt.org.ThirdAdvanced.response.SuccessStatus;

@Getter //이거 안써주면 에러남. 왜그럴까 ? 이 고민은 PR 내용에 정리해둠.
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private final int status;
    private final boolean success;
    private final String message;
    private T data;

    public static ApiResponse success(SuccessStatus success) {
        return new ApiResponse(success.getStatusCode(), true, success.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessStatus success, T data) {
        return new ApiResponse<T>(success.getStatusCode(), true, success.getMessage(), data);
    }

    public static ApiResponse fail(FailStatus fail) {
        return new ApiResponse(fail.getStatusCode(), false, fail.getMessage());
    }

    // 더 자세한 에러 메세지를 내려주고 싶을 때, 메세지를 직접 작성해주기 위해 fail 메서드 오버로딩
    // 사용 예시) MethodArgumentNotValidException 예외 발생 시, 정확히 어떤 필드값이 문제인지 클라분들께 알려주기 위함.
    public static ApiResponse fail(FailStatus fail, String message) {
        return new ApiResponse(fail.getStatusCode(), false, message);
    }
}
