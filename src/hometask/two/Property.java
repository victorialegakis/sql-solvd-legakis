package hometask.two;

import hometask.two.enums.Neighborhood;

public abstract class Property {
    private String id;
    private int price; //will be base price
    private Neighborhood neighborhood;

    public Property(String id, int price, Neighborhood neighborhood) {
        this.id = id;
        setPrice(price);
        this.neighborhood = neighborhood;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    private void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public abstract int calculateFinalPrice();


    @Override
    public String toString() {
        return "ID: " + id +
                ", neighborhood: " + neighborhood +
                ", ";
    }
}
