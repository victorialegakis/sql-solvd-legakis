package hometask.two;


import hometask.two.enums.Neighborhood;

public class Land extends Property {
    private boolean hasSewerSystem;
    private int metersSquare;

    public Land(String ID, int price, Neighborhood neighborhood, boolean hasSewerSystem, int metersSquare) {
        super(ID, price, neighborhood);
        this.hasSewerSystem = hasSewerSystem;
        this.metersSquare = metersSquare;
    }
}

