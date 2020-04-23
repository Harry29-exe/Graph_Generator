package code.Function.Eqation;

public class InvalidFunctionException  extends Exception {
    String message;
    public InvalidFunctionException(String message) {
        this.message = message;
    }
}
