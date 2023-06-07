package sopt.org.SixthSeminar.exception.model;

import sopt.org.SixthSeminar.exception.Error;

public class UnauthorizedException extends GlobalException {
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
