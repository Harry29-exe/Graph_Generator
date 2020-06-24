package code.Function.FunctionsExceptions;

public class InvalidSignException extends Exception {
    String message;

    public InvalidSignException(String message) {
        super();
        this.message = message;
    }
}
