package hometask.two;

import hometask.two.enums.Neighborhood;

public abstract class Edified extends Property {
    private int area;
    private int numberOfSpaces;
    private int numberOfBathrooms;

    public Edified(String ID, int price, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms) {
        super(ID, price, neighborhood);
        setArea(area);
        setNumberOfSpaces(numberOfSpaces);
        setNumberOfBathrooms(numberOfBathrooms);
    }

    private void setNumberOfSpaces(int numberOfSpaces) {
        this.numberOfSpaces = numberOfSpaces;
    }

    private void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    private void setArea(int area) {
        this.area = area;
    }
}

