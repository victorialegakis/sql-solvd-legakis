package hometask.two.exceptions;

public class CustomerNumberInputException extends RuntimeException {
    public CustomerNumberInputException() {
        super("The number you entered does not have a valid format");
    }
}
