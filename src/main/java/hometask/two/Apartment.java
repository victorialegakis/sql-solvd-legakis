package hometask.two;

import hometask.two.enums.ApartmentType;
import hometask.two.enums.Decision;
import hometask.two.enums.Neighborhood;

public final class Apartment extends Edified {
    private int floorNumber;
    private boolean petsAllowed;
    private ApartmentType apartmentType;

    public Apartment(String ID, int basePrice, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms, int floorNumber, boolean petsAllowed, ApartmentType apartmentType) {
        super(ID, basePrice, neighborhood, area, numberOfSpaces, numberOfBathrooms);
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
        int price = getBasePrice();
        if (getArea() > 50) {
            price += (price * 0.05);
        }
        if (getNumberOfBathrooms() >= 2) {
            price += (price * 0.1);
        }
        if (getNumberOfSpaces() >= 3) {
            price += (price * 0.15);
        }
        if (petsAllowed) {
            price += (price * 0.03);
        }
        return price;
    }

    @Override
    public String toString() {
        return "Apartment{" + super.toString() +
                "floorNumber: " + floorNumber +
                ", petsAllowed: " + setPetsAllowed(petsAllowed) +
                ", apartmentType: " + apartmentType +
                "} ";
    }

    @Override
    public void getLeaseInfo() {
        System.out.println("You've chosen to rent. Your desired apartment has a price of " + calculateRentPerMonth()
                + " per month and the lease taxes cover a month of rent, handing over the key and fire insurance:  " + calculateLeaseTaxes() + ".");
    }

    @Override
    public int calculateLeaseTaxes() {
        int price = calculateFinalPrice();
        int keyTaxes = (int) (price * 0.003);
        int fireInsurance = (int) (price * 0.001);

        return (calculateRentPerMonth() + keyTaxes + fireInsurance);
    }

    @Override
    public int calculateRentPerMonth() {
        return (int) (calculateFinalPrice() * 0.015);
    }

    @Override
    public void getSaleInfo() {
        System.out.println("You've chosen to buy. Your desired apartment has a price of " + calculateFinalPrice()
                + "and the sale taxes cover 3% of the apartment value and handing over the key:  " + calculateSalesTaxes() + ".");


    }

    @Override
    public int calculateSalesTaxes() {
        int price = calculateFinalPrice();
        int keyTaxes = (int) (price * 0.005);
        return (int) (price * 0.03 + keyTaxes);
    }
}
