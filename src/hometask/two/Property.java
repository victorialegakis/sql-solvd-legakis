package hometask.two;

import hometask.two.enums.Neighborhood;

public class Property {
    private String ID;
    private int price;
    private Neighborhood neighborhood;

    public Property(String ID, int price, Neighborhood neighborhood) {
        this.ID = ID;
        setPrice(price);
        this.neighborhood = neighborhood;
    }

    public Neighborhood showNeighborhood() {
        return neighborhood;
    }

    private void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static void showHouse(Property p) {
        if (p instanceof House) {
            System.out.println(p);
        }
    }


    public static void showApartments(Property p) {
        if (p instanceof Apartment) {
            System.out.println(p);
        }
    }


    public static void showLands(Property p) {
        if (p instanceof Land) {
            System.out.println(p);
        }
    }

    public int propertiesValueMin(Neighborhood neighborhood) {
        int valueMin = Integer.MAX_VALUE;
        return valueMin;
    }

    public int propertiesValueMax(Neighborhood neighborhood) {
        int valueMax = Integer.MIN_VALUE;
        return valueMax;
    }


    @Override
    public String toString() {
        return "ID: " + ID +
                ", neighborhood: " + neighborhood +
                ", ";
    }
}
