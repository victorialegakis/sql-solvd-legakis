package hometask.two;

public final class Customer extends Person {
    private int budget;

    public Customer(String firstName, String lastName, long phoneNumber, String mailAddress) {
        super(firstName, lastName, phoneNumber, mailAddress);
        setBudget(budget);
    }

    @Override
    public String showFullName(String firstName, String lastName) {
        return "dear customer " + firstName + " " + lastName;

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
}
