package hometask.agency;


import hometask.agency.enums.Decision;
import hometask.agency.enums.Neighborhood;
import hometask.agency.interfaces.ISellable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Land extends Property implements ISellable {
    private boolean hasSewerSystem;
    private int metersSquare;

    final Logger LOG_LAND = LogManager.getLogger(Land.class.getName());

    public Land(String id, int basePrice, Neighborhood neighborhood, boolean hasSewerSystem, int metersSquare) {
        super(id, basePrice, neighborhood);
        setHasSewerSystem(hasSewerSystem);
        this.metersSquare = metersSquare;
    }

    private Decision setHasSewerSystem(boolean hasSewerSystem) {
        Decision systemEnabled;
        if (hasSewerSystem) {
            systemEnabled = Decision.YES;
        } else {
            systemEnabled = Decision.NO;
        }
        return systemEnabled;
    }

    @Override
    public int calculateFinalPrice() {
        int price = getBasePrice();
        if (metersSquare >= 200) {
            price += (price * 0.2);
        }
        if (hasSewerSystem) {
            price += (price * 0.15);
        }
        return price;
    }

    @Override
    public String toString() {
        return "Land{" + super.toString() +
                "hasSewerSystem: " + setHasSewerSystem(hasSewerSystem) +
                ", metersSquare: " + metersSquare +
                "} ";
    }

    @Override
    public void getSaleInfo() {
        LOG_LAND.info("You've chosen to buy. Your desired land has a price of " + calculateFinalPrice()
                + " and the sale taxes cover 2% of the land value and maintenance service:  " + calculateSalesTaxes() + ".");

    }

    @Override
    public int calculateSalesTaxes() {
        int price = calculateFinalPrice();
        int maintenanceServiceTax = (int) (price * 0.001);
        return (int) (calculateFinalPrice() * 0.02 + maintenanceServiceTax);
    }

    @Override
    public void showId() {
        LOG_LAND.info("Land listed no. " + getId());
    }
}



