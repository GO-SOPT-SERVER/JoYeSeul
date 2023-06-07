package sopt.org.SixthSeminar.exception.model;

import sopt.org.SixthSeminar.exception.Error;

public class NotFoundException extends GlobalException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
