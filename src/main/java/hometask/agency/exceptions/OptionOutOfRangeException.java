package hometask.agency.exceptions;

public class OptionOutOfRangeException extends RuntimeException {

    public OptionOutOfRangeException() {
        super("The number you selected is out of the range of options");
    }
}
