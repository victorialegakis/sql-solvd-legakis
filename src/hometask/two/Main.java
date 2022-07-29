package hometask.two;

import hometask.two.enums.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealStateAgency.showNameOfAgency();
        RealStateAgency agency = new RealStateAgency();
        //define brokers
        agency.addBroker(new Broker("Rion", "Ishibashi", 5508591, "RionIshibashi@gustr.com", 2456));
        agency.addBroker(new Broker("Yuzuki", "Ooishi", 2190040, "YuzukiOoishi@gustr.com", 4573));
        agency.addBroker(new Broker("Hoshiyo", "Itou", 3036217, "HoshiyoItou@superrito.com", 1977));
        agency.addBroker(new Broker("Yumito", "Kohara", 7313954, "YumitoKohara@gustr.com", 2789));

        //add properties
        agency.addProperty(new Apartment("32BSP", 40000, Neighborhood.SHINJUKU, 35, 2, 1, 4, true, ApartmentType.STUDIO));
        agency.addProperty(new Apartment("421GD", 58000, Neighborhood.SHIBUYA, 60, 3, 1, 8, false, ApartmentType.LOFT));
        agency.addProperty(new House("887YZ", 180000, Neighborhood.ASAKUSA, 200, 4, 2, true, ConstructionType.PREFABRICATED));
        agency.addProperty(new House("50OUH", 60000, Neighborhood.GINZA, 90, 3, 1, false, ConstructionType.TRADITIONAL));
        agency.addProperty(new Land("11AZC", 4000, Neighborhood.ASAKUSA, true, 300));

        //ask data to the customer
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the following:");
        System.out.println("First name: ");
        String fn = input.nextLine();
        System.out.println("Last name: ");
        String ln = input.nextLine();
        System.out.println("Phone number: ");
        long pn = input.nextLong();
        System.out.println("Mail Address: ");
        String ma = input.next();


        Customer customer = new Customer(fn, ln, pn, ma);
        agency.addCustomer(customer);
        System.out.println("Thank you " + customer.showFullName(fn, ln) + ". Your registration information has been saved.");
        System.out.println("");

        //show Options to the Customer
        System.out.println("We currently have " + agency.quantityOfProperties() + " properties available in all of our website.");
        System.out.println("");
        Neighborhood[] listOfNeighborhoods = Neighborhood.values();
        System.out.println("Where would you like to search a property in?");
        for (Neighborhood n : listOfNeighborhoods) {
            System.out.println((n.ordinal() + 1) + ". " + n);
        }
        int numOfChosenNeighborhood = input.nextInt();
        Neighborhood chosenNeighborhood = listOfNeighborhoods[numOfChosenNeighborhood - 1];
        System.out.println("You've chosen to look for properties in " + chosenNeighborhood + ". " +
                "Would you like to filter by property type?");
        Decision[] options = Decision.values();
        for (Decision logical : options) {
            System.out.println((logical.ordinal() + 1) + ". " + logical);
        }
        int yOrN1 = input.nextInt();

        if (yOrN1 != options[0].ordinal() + 1) {
            System.out.println("Here's a list of all properties in " + chosenNeighborhood + ".");
            agency.showByNeighborhood(chosenNeighborhood);
            System.out.println("");
        } else {
            PropertyType[] typesOfProperties = PropertyType.values();
            for (PropertyType type : typesOfProperties) {
                System.out.println((type.ordinal() + 1) + ". " + type);
            }
            int numOfTypeChosen = input.nextInt();
            PropertyType chosenPropertyType = typesOfProperties[(numOfTypeChosen - 1)];
            System.out.println("You've chosen to look for " + chosenPropertyType + ". Do you have a budget?");
            for (Decision logical : options) {
                System.out.println((logical.ordinal() + 1) + ". " + logical);
            }
            int yOrN2 = input.nextInt();
            if (yOrN2 != options[0].ordinal() + 1) {
                System.out.println("Here's a list of all " + chosenPropertyType + "S in your desired area.");

                System.out.println("");
                System.out.println(chosenPropertyType + "S in " + chosenNeighborhood + "range from propertiesValueMin to propertiesValueMax");
            } else {
                System.out.println("What's your estimated budget?");
                int bd = input.nextInt();
                System.out.println("You've just set up your budget for " + bd + ". Here's all the " + chosenPropertyType + "S in " + chosenNeighborhood +
                        " below or equal to your budget.");
                agency.showByBudget(chosenPropertyType, chosenNeighborhood, bd);
            }
        }
        System.out.println("Thank you for using our services. If you are interested in one of our properties please contact one of our brokers: ");
        agency.showBrokers();


    }
}







