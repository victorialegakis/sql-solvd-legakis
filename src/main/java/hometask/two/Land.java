package hometask.two;


import hometask.two.enums.Decision;
import hometask.two.enums.Neighborhood;
import hometask.two.interfaces.ISellable;

public final class Land extends Property implements ISellable {
    private boolean hasSewerSystem;
    private int metersSquare;

    public Land(String ID, int basePrice, Neighborhood neighborhood, boolean hasSewerSystem, int metersSquare) {
        super(ID, basePrice, neighborhood);
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
        System.out.println("You've chosen to buy. Your desired land has a price of " + calculateFinalPrice()
                + "and the sale taxes cover 2% of the land value and maintenance service:  " + calculateSalesTaxes() + ".");

    }

    @Override
    public int calculateSalesTaxes() {
        int price = calculateFinalPrice();
        int maintenanceServiceTax = (int) (price * 0.001);
        return (int) (calculateFinalPrice() * 0.02 + maintenanceServiceTax);
    }
}



