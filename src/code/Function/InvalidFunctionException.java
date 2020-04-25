package code.Function;

public class InvalidFunctionException  extends Exception {
    String message;
    public InvalidFunctionException(String message) {
        super(message);
    }
}
