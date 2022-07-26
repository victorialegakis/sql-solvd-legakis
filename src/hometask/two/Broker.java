package hometask.two;

public class Broker extends Person {

    private int registrationNumber;
    private static String location;


    public Broker(String firstName, String lastName, int phoneNumber, String mailAddress, int registrationNumber) {
        super(firstName, lastName, phoneNumber, mailAddress);
        this.registrationNumber = registrationNumber;
        Broker.location = "4258 Cimmaron Road, Santa Ana, CA 92701";
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public static String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Broker{"  +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNumber=" + getPhoneNumber() + '\'' +
                ", mailAddress='" + getMailAddress() + '\'' +
                ", registrationNumber=" + registrationNumber + '\'' +
                ", location=" + location +
                '}';
    }
}
