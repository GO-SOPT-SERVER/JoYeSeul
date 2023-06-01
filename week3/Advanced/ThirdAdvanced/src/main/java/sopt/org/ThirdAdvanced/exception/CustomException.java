package sopt.org.ThirdAdvanced.exception;

import lombok.Getter;
import sopt.org.ThirdAdvanced.response.FailStatus;

@Getter
public class CustomException extends RuntimeException {
    private final FailStatus failStatus;

    public CustomException(FailStatus failStatus) {
        super(failStatus.getMessage());
        this.failStatus = failStatus;
    }

    public int getStatusCode() {
        return this.failStatus.getStatusCode();
    }
}
