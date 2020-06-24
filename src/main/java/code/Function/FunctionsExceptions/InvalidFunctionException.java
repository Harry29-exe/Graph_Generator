package code.Function.FunctionsExceptions;

public class InvalidFunctionException  extends Exception {
    String message;
    public InvalidFunctionException(String message) {
        super(message);
    }
}
