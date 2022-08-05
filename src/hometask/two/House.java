package hometask.two;

import hometask.two.enums.ConstructionType;
import hometask.two.enums.Decision;
import hometask.two.enums.Neighborhood;

public final class House extends Edified {
    private boolean hasGarden;
    private ConstructionType constructionType;

    public House(String ID, int price, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms, boolean hasGarden, ConstructionType constructionType) {
        super(ID, price, neighborhood, area, numberOfSpaces, numberOfBathrooms);
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
        return 0;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "hasGarden: " + setHasGarden(hasGarden) +
                ", constructionType: " + constructionType +
                "} ";
    }
}

