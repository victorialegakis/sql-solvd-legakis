package hometask.two.exceptions;

public class IllegalOperationException extends Exception {
    public IllegalOperationException() {
        super("The operation is not allowed for this type of property");
    }
}
