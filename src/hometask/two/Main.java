package hometask.two;

import hometask.two.enums.ApartmentType;
import hometask.two.enums.ConstructionType;
import hometask.two.enums.Neighborhood;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealStateAgency.showNameOfAgency();
        //define brokers
        Broker b1 = new Broker("Rion", "Ishibashi", 5508591,"RionIshibashi@gustr.com", 2456);
        Broker b2 = new Broker("Yuzuki","Ooishi",2190040,"YuzukiOoishi@gustr.com", 4573);
        Broker b3 = new Broker("Hoshiyo", "Itou",3036217,"HoshiyoItou@superrito.com",1977);
        Broker b4 = new Broker("Yumito", "Kohara",7313954,"YumitoKohara@gustr.com", 2789);

        //add properties
        RealStateAgency agency = new RealStateAgency();
        agency.addProperty(new Apartment("32BSP",40000, Neighborhood.SHINJUKU,35,2,1, 4, true, ApartmentType.STUDIO));
        agency.addProperty(new Apartment("421GD",58000, Neighborhood.SHIBUYA,60,3,1, 8, false, ApartmentType.LOFT));
        agency.addProperty(new House("887YZ",180000,Neighborhood.ASAKUSA,200,4,2,true, ConstructionType.PREFABRICATED));
        agency.addProperty(new House("50OUH",60000,Neighborhood.GINZA,90,3,1,false, ConstructionType.TRADITIONAL));
        agency.addProperty(new Land("11AZC",4000,Neighborhood.ASAKUSA,true,300));

        //ask data to the customer
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the following:");
        System.out.println("First name: ");
        String fn = input.nextLine();
        System.out.println("Last name: ");
        String ln = input.nextLine();
        System.out.println("Phone number of 7 digits: ");
        int pn = input.nextInt();
        System.out.println("Budget: ");
        int bd = input.nextInt();
        System.out.println("Mail Address: ");
        String ma = input.next();



        Customer customer = new Customer(fn,ln,pn,ma,bd);
        System.out.println(customer);
        System.out.println("You've just set up your budget for " + bd +
                ". Would you like to filter for something else? Write Y for yes and N for no." );
        String filter = input.next();

        if (filter == "N") {
            agency.showByBudget(bd);

        } else {
            //filter too by property type and neighborhood
        }

    }

}
