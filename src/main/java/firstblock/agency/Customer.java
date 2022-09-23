package firstblock.agency;

import firstblock.agency.interfaces.functional.IContractable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Customer extends Person {
    private int budget;
    private String username;

    final Logger LOG_CUSTOMER = LogManager.getLogger(Customer.class.getName());

    public Customer(String firstName, String lastName, long phoneNumber, String mailAddress) {
        super(firstName, lastName, phoneNumber, mailAddress);
        setBudget(budget);
        this.username = firstName + lastName;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String showFullName(String firstName, String lastName) {
        return "dear customer " + firstName + " " + lastName;

    }

    public void establishContract(IContractable contractable) {
        contractable.makeContract(showFullName(getFirstName(), getLastName()), RealEstateAgency.agencyAddress());
    }


    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {

        return budget;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                ", budget: " + budget +
                "} ";
    }

    @Override
    public void showId() {
        LOG_CUSTOMER.info(username);
    }
}
