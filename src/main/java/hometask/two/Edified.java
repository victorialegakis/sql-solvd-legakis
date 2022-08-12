package hometask.two;

import hometask.two.enums.Neighborhood;
import hometask.two.interfaces.IOperable;

public abstract class Edified extends Property implements IOperable {
    private int area;
    private int numberOfSpaces;
    private int numberOfBathrooms;

    public Edified(String ID, int basePrice, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms) {
        super(ID, basePrice, neighborhood);
        setArea(area);
        setNumberOfSpaces(numberOfSpaces);
        setNumberOfBathrooms(numberOfBathrooms);
    }

    private void setNumberOfSpaces(int numberOfSpaces) {
        if (numberOfSpaces > 0) {
            this.numberOfSpaces = numberOfSpaces;
        }
    }

    private void setNumberOfBathrooms(int numberOfBathrooms) {
        if (numberOfBathrooms > 0) {
            this.numberOfBathrooms = numberOfBathrooms;
        }
    }

    private void setArea(int area) {
        if (area > 0) {
            this.area = area;
        }
    }

    public int getArea() {
        return area;
    }

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }
}
