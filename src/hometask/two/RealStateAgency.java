package hometask.two;

import hometask.two.enums.Neighborhood;
import hometask.two.enums.PropertyType;

import java.util.ArrayList;

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

    public void showByNeighborhood(Neighborhood n) {
        for (Property p : listOfProperties) {
            if (p.showNeighborhood() == n) {
                System.out.println(p);
            }
        }
    }

    public void showPropertyType(PropertyType type, Neighborhood n) {
        for (Property p : listOfProperties) {
            if (p.showNeighborhood() == n) {
                if (type.equals(PropertyType.HOUSE)) {
                    Property.showHouse(p);
                } else if (type.equals(PropertyType.APARTMENT)) {
                    Property.showApartments(p);
                } else {
                    Property.showLands(p);
                }
            }
        }
    }


    public void showByBudget(PropertyType type, Neighborhood n, int budget) {
        for (Property p : listOfProperties) {
            if (p.getPrice() <= budget) {
                showPropertyType(type, n);
            }
        }

    }


    public void addProperty(Property p) {
        this.listOfProperties.add(p);
    }

    public void addBroker(Broker b) {
        this.listOfBrokers.add(b);
    }

    public void addCustomer(Customer c) {
        this.listOfCustomers.add(c);
    }

}
