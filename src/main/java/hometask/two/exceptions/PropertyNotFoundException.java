package hometask.two.exceptions;

public class PropertyNotFoundException extends Exception {
    public PropertyNotFoundException() {
        super("There was no property in our site that met the requirements");
    }
}
