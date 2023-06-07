package sopt.org.SixthSeminar.exception.model;

import lombok.Getter;
import sopt.org.SixthSeminar.exception.Error;

@Getter
public class GlobalException extends RuntimeException {

    private final Error error;

    public GlobalException(Error error, String message) {
        super(message);
        this.error = error;
    }
}
