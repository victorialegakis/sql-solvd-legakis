package hometask.two;


import hometask.two.enums.Decision;
import hometask.two.enums.Neighborhood;
import hometask.two.interfaces.Leaseable;

public final class Land extends Property implements Leaseable {
    private boolean hasSewerSystem;
    private int metersSquare;

    public Land(String ID, int price, Neighborhood neighborhood, boolean hasSewerSystem, int metersSquare) {
        super(ID, price, neighborhood);
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

        return 0;
    }

    @Override
    public String toString() {
        return "Land{" + super.toString() +
                "hasSewerSystem: " + setHasSewerSystem(hasSewerSystem) +
                ", metersSquare: " + metersSquare +
                "} ";
    }

    @Override
    public void getLeaseInfo() {
        System.out.println("Here's the details of the leasing ");
    }

    @Override
    public int calculateLeaseTaxes() {
        return 0;
    }
}


