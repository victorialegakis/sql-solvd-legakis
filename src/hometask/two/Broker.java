package hometask.two;

public final class Broker extends Person {

    private int registrationNumber;
    private static String location;


    public Broker(String firstName, String lastName, long phoneNumber, String mailAddress, int registrationNumber) {
        super(firstName, lastName, phoneNumber, mailAddress);
        this.registrationNumber = registrationNumber;
        Broker.location = "4258 Cimmaron Road, Santa Ana, CA 92701";
    }

    @Override
    public String showFullName(String firstName, String lastName) {
        return "Broker " + firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Broker{" + super.toString() +
                ", registrationNumber: " + registrationNumber +
                "} ";
    }
}
