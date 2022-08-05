package hometask.two;

import hometask.two.enums.ApartmentType;
import hometask.two.enums.Decision;
import hometask.two.enums.Neighborhood;

public final class Apartment extends Edified {
    private int floorNumber;
    private boolean petsAllowed;
    private ApartmentType apartmentType;

    public Apartment(String ID, int price, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms, int floorNumber, boolean petsAllowed, ApartmentType apartmentType) {
        super(ID, price, neighborhood, area, numberOfSpaces, numberOfBathrooms);
        this.floorNumber = floorNumber;
        setPetsAllowed(petsAllowed);
        this.apartmentType = apartmentType;
    }

    private Decision setPetsAllowed(boolean petsAllowed) {
        Decision areAllowed;
        if (petsAllowed) {
            areAllowed = Decision.YES;
        } else {
            areAllowed = Decision.NO;
        }
        return areAllowed;
    }


    @Override
    public int calculateFinalPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Apartment{" + super.toString() +
                "floorNumber: " + floorNumber +
                ", petsAllowed: " + setPetsAllowed(petsAllowed) +
                ", apartmentType: " + apartmentType +
                "} ";
    }
}
