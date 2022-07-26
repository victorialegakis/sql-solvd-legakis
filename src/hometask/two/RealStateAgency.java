package hometask.two;
import java.util.ArrayList;

public class RealStateAgency {
    private static final String nameOfAgency = "Asahi Real Estate";
    private ArrayList<Property> listOfProperties;
    private Person person;
    private Service service;

    public RealStateAgency() {
        this.listOfProperties = listOfProperties;
    }


    public static void showNameOfAgency() {
        System.out.println("Welcome to " + nameOfAgency + " services. We are glad to have you here.");
    }

    public static void showBroker(Broker b1, Broker b2, Broker b3, Broker b4) {
        System.out.println("If you are interested please contact one of our brokers");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);

    }

    public void showByBudget(int bd) {
        for (Property p : listOfProperties) {
            if (p.getPrice() <= bd) {
                System.out.println(p);
            }
        }

    }
    public void addProperty(Property p) {
        this.listOfProperties.add(p);
    }
}



