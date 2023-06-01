package sopt.org.ThirdAdvanced.common.advice;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.ThirdAdvanced.common.dto.ApiResponse;
import sopt.org.ThirdAdvanced.exception.CustomException;
import sopt.org.ThirdAdvanced.response.FailStatus;

import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class) // @Valid 유효성 검사에서 발생하는 예외
    protected ApiResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        FieldError fieldError = Objects.requireNonNull(e.getFieldError());
        return ApiResponse.fail(FailStatus.VALIDATION_EXCEPTION, String.format("%s. (%s)", fieldError.getDefaultMessage(), fieldError.getField()));
    }

    /**
     * 404 NOT_FOUND
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ApiResponse> handleCustomException(final CustomException e) {
        return ResponseEntity.status(e.getStatusCode())
                .body(ApiResponse.fail(e.getFailStatus(), e.getMessage()));
    }

    /**
     * 409 CONFLICT
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    protected ApiResponse handleDuplicationKeyException(final DuplicateKeyException e) {
        return ApiResponse.fail(FailStatus.CONFLICT_NICKNAME_EXCEPTION);
    }

    /**
     * 500 SERVER_ERROR
     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    protected ApiResponse handleException(final Exception e) {
//        return ApiResponse.fail(FailStatus.INTERNAL_SERVER_ERROR);
//    }
}
