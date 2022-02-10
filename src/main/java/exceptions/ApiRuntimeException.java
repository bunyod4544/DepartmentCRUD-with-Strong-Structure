package exceptions;


public class ApiRuntimeException extends RuntimeException {

    public ApiRuntimeException(String message) {
        super(message);
    }
}
