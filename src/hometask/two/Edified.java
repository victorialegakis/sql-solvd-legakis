package hometask.two;

import hometask.two.enums.Neighborhood;

public class Edified extends Property {
    private int area;
    private int numberOfSpaces;
    private int numberOfBathrooms;

    public Edified(String ID, int price, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms) {
        super(ID, price, neighborhood);
        setArea(area);
        setNumberOfSpaces(numberOfSpaces);
        setNumberOfBathrooms(numberOfBathrooms);
    }

    public void setNumberOfSpaces(int numberOfSpaces) {
        this.numberOfSpaces = numberOfSpaces;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setArea(int area) {
        this.area = area;
    }
}

