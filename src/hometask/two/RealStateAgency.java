package hometask.two;

import hometask.two.enums.Neighborhood;
import hometask.two.enums.PropertyType;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RealStateAgency {
    private static final String nameOfAgency = "Asahi Real Estate";
    private ArrayList<Property> listOfProperties;
    private ArrayList<Broker> listOfBrokers;
    private ArrayList<Customer> listOfCustomers;

    public RealStateAgency() {
        this.listOfProperties = new ArrayList<>();
        this.listOfBrokers = new ArrayList<>();
        this.listOfCustomers = new ArrayList<>();
    }


    public static void showNameOfAgency() {
        System.out.println("Welcome to " + nameOfAgency + " services. We are glad to have you here.");
    }

    public int quantityOfProperties() {

        return listOfProperties.size();
    }


    public void showBrokers() {
        for (Broker b : listOfBrokers) {
            System.out.println(b.showFullName(b.getFirstName(), b.getLastName()));
            System.out.println(b);
        }
    }

    public ArrayList getListByNeighborhood(Neighborhood n) {
        ArrayList<Property> propertiesByNeighborhood = new ArrayList<>();
        for (Property p : listOfProperties) {
            if (p.getNeighborhood() == n) {
                propertiesByNeighborhood.add(p);
            }
        }
        return propertiesByNeighborhood;
    }

    public ArrayList<Property> getListByPropertyTypeAndNeighborhood(PropertyType type, Neighborhood n) {
        ArrayList<Property> listByNeighborhood = getListByNeighborhood(n);
        ArrayList<Property> propertiesByTypeAndNeighborhood = new ArrayList<>();
        for (Property p : listByNeighborhood) {
            String pClass = p.getClass().getSimpleName();
            if (pClass.equalsIgnoreCase(String.valueOf(type))) {
                propertiesByTypeAndNeighborhood.add(p);
            }

        }
        return propertiesByTypeAndNeighborhood;
    }

    public ArrayList<Property> getListByPropertyTypeNeighborhoodAndBudget(PropertyType type, Neighborhood n, int budget) {
        ArrayList<Property> listByPropertyTypeAndNeighborhood = getListByPropertyTypeAndNeighborhood(type, n);
        ArrayList<Property> propertiesByTypeNeighborhoodAndBudget = new ArrayList<>();
        for (Property p : listByPropertyTypeAndNeighborhood) {
            if (p.getPrice() <= budget) {
                propertiesByTypeNeighborhoodAndBudget.add(p);
            }
        }
        return propertiesByTypeNeighborhoodAndBudget;
    }

    public void addBroker(Broker broker) {
        this.listOfBrokers.add(broker);
    }

    public void addProperty(Property property) {
        this.listOfProperties.add(property);
    }

    private void addCustomer(Customer customer) {
        this.listOfCustomers.add(customer);
    }

    public Customer askAndSaveCustomerData() {
        //apply try except and logger
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the following:");
        System.out.println("First name: ");
        String fn = input.nextLine();
        System.out.println("Last name: ");
        String ln = input.nextLine();
        System.out.println("Mail Address: ");
        String ma = input.nextLine();
        System.out.println("Phone number: ");
        long pn = 0;
        try {
            pn = input.nextLong();
        } catch (InputMismatchException e) {
            LogManager.getLogger(RealStateAgency.class).atError().log("You haven't entered a long number");
        }
        Customer customer = new Customer(fn, ln, pn, ma);
        addCustomer(customer);
        return customer;
    }
}
