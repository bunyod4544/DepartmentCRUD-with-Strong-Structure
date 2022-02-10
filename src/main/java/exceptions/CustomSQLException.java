package exceptions;

import enums.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomSQLException extends BaseException {

    public CustomSQLException(String message, HttpStatus status) {
        super(message, status);
    }

    public CustomSQLException(String message, Throwable cause) {
        super(message, cause);
    }
}
