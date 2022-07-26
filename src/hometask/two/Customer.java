package hometask.two;

public class Customer extends Person {
    private int budget;

    public Customer(String firstName, String lastName, int phoneNumber, String mailAddress, int budget) {
        super(firstName, lastName, phoneNumber, mailAddress);
        setBudget(budget);
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNumber=" + getPhoneNumber() + '\'' +
                ", mailAddress='" + getMailAddress() + '\'' +
                ", budget=" + budget +
                '}';
    }
}
