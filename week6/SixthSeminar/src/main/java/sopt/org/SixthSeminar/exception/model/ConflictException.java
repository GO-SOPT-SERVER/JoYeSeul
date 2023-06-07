package sopt.org.SixthSeminar.exception.model;

import sopt.org.SixthSeminar.exception.Error;

public class ConflictException extends GlobalException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
