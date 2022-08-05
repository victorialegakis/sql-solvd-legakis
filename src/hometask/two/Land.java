package hometask.two;


import hometask.two.enums.Decision;
import hometask.two.enums.Neighborhood;

public final class Land extends Property {
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
}


