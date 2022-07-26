package hometask.two;

import hometask.two.enums.ApartmentType;
import hometask.two.enums.Neighborhood;

public class Apartment extends Edified {
    private int floorNumber;
    private boolean petsAllowed;
    private ApartmentType apartmentType;

    public Apartment(String ID, int price, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms, int floorNumber, boolean petsAllowed, ApartmentType apartmentType) {
        super(ID, price, neighborhood, area, numberOfSpaces, numberOfBathrooms);
        this.floorNumber = floorNumber;
        this.petsAllowed = petsAllowed;
        this.apartmentType = apartmentType;
    }
}
