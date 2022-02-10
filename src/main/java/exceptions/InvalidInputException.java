package exceptions;

import enums.HttpStatus;
import lombok.Getter;


@Getter
public class InvalidInputException extends BaseException {
    private final HttpStatus status;

    public InvalidInputException(String message, HttpStatus status) {
        super(message, status);
        this.status = HttpStatus.HTTP_400;
    }
}
