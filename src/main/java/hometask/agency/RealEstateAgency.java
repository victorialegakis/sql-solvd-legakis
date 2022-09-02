package hometask.agency;

import hometask.agency.exceptions.CustomerEmailInputException;
import hometask.agency.exceptions.CustomerNumberInputException;
import hometask.agency.exceptions.IllegalOperationException;
import hometask.agency.exceptions.PropertyNotFoundException;
import hometask.agency.generics.CustomLinkedList;
import hometask.agency.interfaces.functional.IBookable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RealEstateAgency {
    private static final String nameOfAgency = "Asahi Real Estate";
    private ArrayList<Property> listOfProperties;
    private CustomLinkedList<Broker> listOfBrokers;
    private ArrayList<Customer> listOfCustomers;

    static final Logger LOG_AGENCY = LogManager.getLogger(RealEstateAgency.class.getName());

    public RealEstateAgency() {
        this.listOfProperties = new ArrayList<>();
        this.listOfBrokers = new CustomLinkedList<>();
        this.listOfCustomers = new ArrayList<>();
    }

    public static void showNameOfAgency() {
        LOG_AGENCY.info("Welcome to " + nameOfAgency + " services. We are glad to have you here.");
    }

    public static String agencyAddress() {
        return "4258 Cimmaron Road, Santa Ana, CA 92701";
    }

    public int quantityOfProperties() {

        return listOfProperties.size();
    }


    public void showBrokers() {
        listOfBrokers.print();
    }

    public CustomLinkedList<Broker> getListOfBrokers() {
        return listOfBrokers;
    }

    public ArrayList<Property> listOfPropertiesFilteredByRule(Predicate<Property> p) {
        return (ArrayList<Property>) listOfProperties.stream().filter(p).collect(Collectors.toList());
    }

    public void addBroker(Broker broker) {
        this.listOfBrokers.addLast(broker);
    }

    public void addProperty(Property property) {
        this.listOfProperties.add(property);
    }

    private void addCustomer(Customer customer) {
        this.listOfCustomers.add(customer);
    }

    public Customer askAndSaveCustomerData() {

        Scanner scanner = new Scanner(System.in);
        LOG_AGENCY.info("Please enter the following:");
        LOG_AGENCY.info("First name: ");
        String fn = scanner.nextLine();
        LOG_AGENCY.info("Last name: ");
        String ln = scanner.nextLine();
        LOG_AGENCY.info("Mail Address: ");
        String ma = scanner.nextLine();
        if (!ma.contains("@")) {
            throw new CustomerEmailInputException();
        }
        LOG_AGENCY.info("Phone number: ");
        long pn = 0;
        pn = scanner.nextLong();
        if (pn > Integer.MAX_VALUE) {
            throw new CustomerNumberInputException();
        }
        Customer customer = new Customer(fn, ln, pn, ma);
        addCustomer(customer);
        return customer;
    }

    public Property getPropertyByID(String idSelected) throws PropertyNotFoundException {
        Property propertyByID = null;
        for (Property p : listOfProperties) {
            if (idSelected.equals(p.getId())) {
                propertyByID = p;
                break;
            }
        }
        if (propertyByID == null) {
            throw new PropertyNotFoundException();
        }
        return propertyByID;
    }


    public void showSaleOrLeaseInfo(Property propertySelected, int op) throws IllegalOperationException {
        try {
            String propertySelectedClass = propertySelected.getClass().getSimpleName();
            if (propertySelectedClass.equals("Land")) {
                if (op == 1) {
                    throw new IllegalOperationException();
                } else {
                    //downcasting
                    Land landSelected = (Land) propertySelected;
                    landSelected.getSaleInfo();
                }
            } else {
                //downcasting
                Edified edifiedSelected = (Edified) propertySelected;
                if (op == 1) {
                    edifiedSelected.getLeaseInfo();
                } else {
                    edifiedSelected.getSaleInfo();
                }
            }
        } catch (NullPointerException e) {
            LOG_AGENCY.error("The property has not been selected");
        }
    }

    public String addAppointment(IBookable bookable) {
        return bookable.bookAppointment(askAndSaveCustomerData());
    }
}
