package sopt.org.SixthSeminar.exception.model;

import sopt.org.SixthSeminar.exception.Error;

public class BadRequestException extends GlobalException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
