package hometask.two;

import hometask.two.enums.*;
import hometask.two.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final Logger LOG_MAIN = LogManager.getLogger(Main.class.getName());
        //show name of Agency
        RealStateAgency.showNameOfAgency();
        //create an instance of Real Estate Agency
        RealStateAgency agency = new RealStateAgency();
        //define brokers
        agency.addBroker(new Broker("Rion", "Ishibashi", 5508591, "RionIshibashi@gustr.com", 2456));
        agency.addBroker(new Broker("Yuzuki", "Ooishi", 2190040, "YuzukiOoishi@gustr.com", 4573));
        agency.addBroker(new Broker("Hoshiyo", "Itou", 3036217, "HoshiyoItou@superrito.com", 1977));
        agency.addBroker(new Broker("Yumito", "Kohara", 7313954, "YumitoKohara@gustr.com", 2789));

        //add Apartments
        agency.addProperty(new Apartment("32BSP", 50000, Neighborhood.SHINJUKU, 35, 2, 1, 4, true, ApartmentType.STUDIO));
        agency.addProperty(new Apartment("32BTQ", 50000, Neighborhood.SHINJUKU, 50, 3, 1, 9, false, ApartmentType.LOFT));
        agency.addProperty(new Apartment("61BUR", 90000, Neighborhood.ASAKUSA, 80, 3, 2, 12, true, ApartmentType.TWO_BEDROOM));
        agency.addProperty(new Apartment("421GD", 80000, Neighborhood.SHIBUYA, 60, 3, 1, 8, false, ApartmentType.LOFT));
        agency.addProperty(new Apartment("421HE", 80000, Neighborhood.SHIBUYA, 70, 3, 1, 7, false, ApartmentType.TWO_BEDROOM));
        agency.addProperty(new Apartment("739RF", 100000, Neighborhood.GINZA, 40, 2, 1, 16, false, ApartmentType.STUDIO));
        //add Houses
        agency.addProperty(new House("887YZ", 180000, Neighborhood.ASAKUSA, 200, 4, 2, true, ConstructionType.PREFABRICATED));
        agency.addProperty(new House("50OUH", 200000, Neighborhood.GINZA, 120, 3, 1, false, ConstructionType.TRADITIONAL));
        agency.addProperty(new House("50OVW", 200000, Neighborhood.GINZA, 90, 3, 1, true, ConstructionType.TRADITIONAL));
        agency.addProperty(new House("94FTU", 130000, Neighborhood.SHIBUYA, 80, 3, 1, true, ConstructionType.PREFABRICATED));
        // add Lands
        agency.addProperty(new Land("11AZC", 4000, Neighborhood.ASAKUSA, true, 300));
        agency.addProperty(new Land("97IDW", 7000, Neighborhood.SHIBUYA, false, 150));
        agency.addProperty(new Land("56IDW", 10000, Neighborhood.SHINJUKU, false, 200));
        //ask data to the customer
        Customer costumerData = null;
        try {
            costumerData = agency.askAndSaveCustomerData();
        } catch (CustomerEmailInputException e) {
            LOG_MAIN.error(e.getMessage());
        } catch (CustomerNumberInputException e) {
            LOG_MAIN.error(e.getMessage());
            //add retry logic
        }
        //give back username for the customer
        try {
            LOG_MAIN.info("Thank you " + costumerData.showFullName(costumerData.getFirstName(), costumerData.getLastName()) + ". Your registration information has been saved.");
            LOG_MAIN.info("Your username has been automatically generated to " + costumerData.getUsername().toLowerCase() + " for future visits.");
        } catch (NullPointerException e) {
            LOG_MAIN.warn("The customer data has not been fully collected");
            //add retry logic
        }

        //show Options to the Customer
        LOG_MAIN.info("We currently have " + agency.quantityOfProperties() + " properties available in all of our website.");

        LOG_MAIN.info("Where would you like to search a property in?");

        //show neighborhoods where properties are located
        Neighborhood.showNeighborhoodsByNumber();

        //save option of neighborhood chosen
        Neighborhood chosenNeighborhood = null;
        try {
            int numOfChosenNeighborhood = input.nextInt();
            chosenNeighborhood = Neighborhood.saveChosenNeighborhood(numOfChosenNeighborhood);
        } catch (OptionOutOfRangeException e) {
            LOG_MAIN.warn(e.getMessage());
            //gives by default the value of the first neighborhood
            chosenNeighborhood = Neighborhood.values()[0];
        }
        //ask if they would like to filter by property type as well
        LOG_MAIN.info("You've chosen to look for properties in " + chosenNeighborhood + ". " +
                "Would you like to filter by property type?");
        //show Yes or No option
        Decision.showOptionsByNumber();

        //save the option of the customer
        int yesOrNo1 = input.nextInt();

        //if it's no, it'll just show all properties in the selected neighborhood,
        // else it will show a list of property types to choose from.
        Neighborhood finalChosenNeighborhood = chosenNeighborhood;
        if (yesOrNo1 != 1) {
            LOG_MAIN.info("Here's a list of all properties in " + chosenNeighborhood + ".");
            LOG_MAIN.info(agency.listOfPropertiesFilteredByRule(property -> finalChosenNeighborhood.equals(property.getNeighborhood())));

        } else {
            //show property types options
            PropertyType.showPropertyTypesByNumber();

            //save type of property chosen
            int numOfTypeChosen = input.nextInt();
            PropertyType chosenPropertyType = PropertyType.saveChosenPropertyType(numOfTypeChosen);

            //ask if they would like to filter by budget as well
            LOG_MAIN.info("You've chosen to look for " + chosenPropertyType + ". Do you have a budget?");
            Decision.showOptionsByNumber();

            //save Yes or No option selected
            int yesOrNo2 = input.nextInt();

            //if it's no, it'll show properties of that property type in the desired neighborhood.
            // else it'll ask for the customer budget

            if (yesOrNo2 != 1) {
                LOG_MAIN.info("Here's a list of all " + chosenPropertyType + "S in your desired area.");
                LOG_MAIN.info(agency.listOfPropertiesFilteredByRule(property -> finalChosenNeighborhood.equals(property.getNeighborhood()) && property.getClass().getSimpleName().equalsIgnoreCase(String.valueOf(chosenPropertyType))));


            } else {
                LOG_MAIN.info("What's your estimated budget?");

                //save the customers budget
                int bd = input.nextInt();
                costumerData.setBudget(bd);
                LOG_MAIN.info("You've just set up your budget for " + costumerData.getBudget() + ". Here's all the " + chosenPropertyType + "S in " + chosenNeighborhood +
                        " below or equal to your budget.");

                //show properties in the below or equal to the budget, of the desired property type
                // and in the neighborhood selected.
                Customer finalCostumerData = costumerData;
                LOG_MAIN.info(agency.listOfPropertiesFilteredByRule(property -> finalChosenNeighborhood.equals(property.getNeighborhood()) && property.getClass().getSimpleName().equalsIgnoreCase(String.valueOf(chosenPropertyType)) && property.calculateFinalPrice() <= finalCostumerData.getBudget()));
            }
        }
        LOG_MAIN.info("Are you interested in any of the properties shown before?");
        Decision.showOptionsByNumber();
        int yesOrNo3 = input.nextInt();
        if (yesOrNo3 == 1) {
            LOG_MAIN.info("Please enter the ID of the property you'd like more info in");
            String idSelected = input.next();
            Property propertySelected = null;
            try {
                propertySelected = agency.getPropertyByID(idSelected);
            } catch (PropertyNotFoundException e) {
                LOG_MAIN.info(e.getMessage());
                //add retry logic
            }

            //ask if the customer would like to rent or buy the property selected. It would say
            //if its for sale or rent or both and show the info needed to proceed with the operation.
            LOG_MAIN.info("Are you interested in renting or buying the property selected?");
            costumerData.establishContract((costumer, address) -> LOG_MAIN.info("The contract will be established for " + costumer + " for the desired property in our agency, located at " + address));
            Operation.showOperationsByNumber();
            int op = input.nextInt();
            try {
                agency.showSaleOrLeaseInfo(propertySelected, op);
            } catch (IllegalOperationException e) {
                LOG_MAIN.error("Lands are not up for rent");
            }

        }
        LOG_MAIN.info("Would you like to set an appointment for more information?");
        Decision.showOptionsByNumber();
        int yesOrNo4 = input.nextInt();
        if (yesOrNo4 == 1) {
            LOG_MAIN.info(agency.addAppointment((customer) -> {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                return "Your appointment is set to " + formatter.format(date);
            }));
        }
        LOG_MAIN.info("Thank you for using our services. Please contact one of our brokers if you would like another type of information: ");
        //add method print to linked list
        agency.showBrokers();


    }
}







