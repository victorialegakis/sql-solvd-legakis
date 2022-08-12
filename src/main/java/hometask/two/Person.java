package hometask.two;

import hometask.two.interfaces.IIdentifiable;

public abstract class Person implements IIdentifiable {
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String mailAddress;

    public Person(String firstName, String lastName, long phoneNumber, String mailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        setPhoneNumber(phoneNumber);
        this.mailAddress = mailAddress;
    }

    public abstract String showFullName(String firstName, String lastName);

    private void setPhoneNumber(long phoneNumber) {
        if (phoneNumber > 0) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName +
                ", lastName: " + lastName +
                ", phoneNumber: " + phoneNumber +
                ", mailAddress: " + mailAddress;
    }
}
