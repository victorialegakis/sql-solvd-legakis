package hometask.agency;

import hometask.agency.enums.ConstructionType;
import hometask.agency.enums.Decision;
import hometask.agency.enums.Neighborhood;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class House extends Edified {
    private boolean hasGarden;
    private ConstructionType constructionType;

    final Logger LOG_HOUSE = LogManager.getLogger(House.class.getName());

    public House(String id, int basePrice, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms, boolean hasGarden, ConstructionType constructionType) {
        super(id, basePrice, neighborhood, area, numberOfSpaces, numberOfBathrooms);
        setHasGarden(hasGarden);
        this.constructionType = constructionType;
    }

    private Decision setHasGarden(boolean hasGarden) {
        Decision garden;
        if (hasGarden) {
            garden = Decision.YES;
        } else {
            garden = Decision.NO;
        }
        return garden;
    }


    @Override
    public int calculateFinalPrice() {
        int price = getBasePrice();
        if (getArea() > 100) {
            price += (price * 0.05);
        }
        if (getNumberOfBathrooms() >= 2) {
            price += (price * 0.1);
        }
        if (getNumberOfSpaces() >= 3) {
            price += (price * 0.15);
        }
        if (hasGarden) {
            price += (price * 0.2);
        }
        return price;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "hasGarden: " + setHasGarden(hasGarden) +
                ", constructionType: " + constructionType +
                "} ";
    }

    @Override
    public void getLeaseInfo() {
        LOG_HOUSE.info("You've chosen to rent. Your desired house has a price of " + calculateRentPerMonth()
                + " per month and the lease taxes cover a month of rent, handing over the key and fire insurance:  " + calculateLeaseTaxes() + ".");
    }

    @Override
    public int calculateLeaseTaxes() {
        int price = calculateFinalPrice();
        int keyTaxes = (int) (price * 0.005);
        int fireInsurance = (int) (price * 0.002);

        return (calculateRentPerMonth() + keyTaxes + fireInsurance);
    }

    @Override
    public int calculateRentPerMonth() {
        return (int) (calculateFinalPrice() * 0.02);
    }

    @Override
    public void getSaleInfo() {
        LOG_HOUSE.info("You've chosen to buy. Your desired house has a price of " + calculateFinalPrice()
                + " and the sale taxes cover 5% of the house value and handing over the key:  " + calculateSalesTaxes() + ".");

    }

    @Override
    public int calculateSalesTaxes() {
        int price = calculateFinalPrice();
        int keyTaxes = (int) (price * 0.005);
        return (int) (price * 0.05 + keyTaxes);
    }

    @Override
    public void showId() {
        LOG_HOUSE.info("House listed as no. " + getId());
    }
}

