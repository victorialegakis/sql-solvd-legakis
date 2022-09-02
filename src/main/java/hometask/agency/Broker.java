package hometask.agency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Broker extends Person {

    private int registrationNumber;
    private static String location;

    final Logger LOG_BROKER = LogManager.getLogger(Broker.class.getName());

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
                ", location: " + location +
                "} ";
    }

    @Override
    public void showId() {
        LOG_BROKER.info(registrationNumber);
    }
}
