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

    private void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }

    public int getPrice() {
        return price;
    }


    public String getID() {
        return ID;
    }

}
