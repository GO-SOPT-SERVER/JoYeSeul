package sopt.org.ThirdAdvanced.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /**
     * 200 OK
     */
    READ_USER_SUCCESS(HttpStatus.OK, "유저 조회 성공"),
    READ_POST_SUCCESS(HttpStatus.OK, "해당하는 게시물을 조회 성공하였습니다."),
    READ_COMMENT_SUCCESS(HttpStatus.OK, "게시물에 달린 댓글들을 조회 성공하였습니다."),

    /**
     * 201 CREATE
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),
    CREATE_POST_SUCCESS(HttpStatus.CREATED, "게시물 생성이 완료되었습니다."),
    CREATE_COMMENT_SUCCESS(HttpStatus.CREATED, "댓글 생성이 완료되었습니다."),


    /**
     * 204 NO_CONTENT
     */
    NO_CONTENT_COMMENT(HttpStatus.NO_CONTENT, "해당 게시물에 달린 댓글이 없습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getStatusCode() {
        return this.httpStatus.value();
    }
}

