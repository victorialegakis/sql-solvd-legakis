package hometask.two;

import hometask.two.enums.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
        Customer costumerData = agency.askAndSaveCustomerData();

        //give back username for the customer
        System.out.println("Thank you " + costumerData.showFullName(costumerData.getFirstName(), costumerData.getLastName()) + ". Your registration information has been saved.");
        System.out.println("");
        System.out.println("Your username has been automatically generated to " + costumerData.getUsername().toLowerCase() + " for future visits.");


        //show Options to the Customer
        System.out.println("We currently have " + agency.quantityOfProperties() + " properties available in all of our website.");
        System.out.println("");
        System.out.println("Where would you like to search a property in?");

        //show neighborhoods where properties are located
        Neighborhood.showNeighborhoodsByNumber();

        //save option of neighborhood chosen
        int numOfChosenNeighborhood = input.nextInt();
        Neighborhood chosenNeighborhood = Neighborhood.saveChosenNeighborhood(numOfChosenNeighborhood);

        //ask if they would like to filter by property type as well
        System.out.println("You've chosen to look for properties in " + chosenNeighborhood + ". " +
                "Would you like to filter by property type?");
        //show Yes or No option
        Decision.showOptionsByNumber();

        //save the option of the customer
        int yesOrNo1 = input.nextInt();

        //if it's no, it'll just show all properties in the selected neighborhood,
        // else it will show a list of property types to choose from.
        if (yesOrNo1 != Decision.getOptionsByNumber()[0].ordinal() + 1) {
            System.out.println("Here's a list of all properties in " + chosenNeighborhood + ".");
            System.out.println(agency.getListByNeighborhood(chosenNeighborhood));
            System.out.println("");

        } else {
            //show property types options
            PropertyType.showPropertyTypesByNumber();

            //save type of property chosen
            int numOfTypeChosen = input.nextInt();
            PropertyType chosenPropertyType = PropertyType.saveChosenPropertyType(numOfTypeChosen);

            //ask if they would like to filter by budget as well
            System.out.println("You've chosen to look for " + chosenPropertyType + ". Do you have a budget?");
            Decision.showOptionsByNumber();

            //save Yes or No option selected
            int yesOrNo2 = input.nextInt();

            //if it's no, it'll show properties of that property type in the desired neighborhood.
            // else it'll ask for the customer budget

            if (yesOrNo2 != Decision.getOptionsByNumber()[0].ordinal() + 1) {
                System.out.println("Here's a list of all " + chosenPropertyType + "S in your desired area.");
                System.out.println(agency.getListByPropertyTypeAndNeighborhood(chosenPropertyType, chosenNeighborhood));
                System.out.println("");

            } else {
                System.out.println("What's your estimated budget?");

                //save the customers budget
                int bd = input.nextInt();
                costumerData.setBudget(bd);
                System.out.println("You've just set up your budget for " + costumerData.getBudget() + ". Here's all the " + chosenPropertyType + "S in " + chosenNeighborhood +
                        " below or equal to your budget.");

                //show properties in the below or equal to the budget, of the desired property type
                // and in the neighborhood selected.
                System.out.println(agency.getListByPropertyTypeNeighborhoodAndBudget(chosenPropertyType, chosenNeighborhood, bd));
            }
        }

        //ask if the customer would like to rent or buy the property selected. It would say
        //if its for sale or rent or both and show the info needed to proceed with the operation.
        System.out.println("Are you interested in renting or buying the property selected?");
        Operation.showOperationsByNumber();
        int op = input.nextInt();
        //implement the interfaces methods


        System.out.println("Thank you for using our services. Please contact one of our brokers for more information: ");
        agency.showBrokers();


    }
}







