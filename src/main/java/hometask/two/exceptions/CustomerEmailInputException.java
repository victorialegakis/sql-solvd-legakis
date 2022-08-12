package hometask.two.exceptions;

public class CustomerEmailInputException extends RuntimeException {
    public CustomerEmailInputException() {
        super("The email you've entered does not have a valid format");
    }
}
