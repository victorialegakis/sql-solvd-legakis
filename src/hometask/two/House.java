package hometask.two;

import hometask.two.enums.ConstructionType;
import hometask.two.enums.Neighborhood;

public class House extends Edified {
    private boolean hasGarden;
    private ConstructionType constructionType;

    public House(String ID, int price, Neighborhood neighborhood, int area, int numberOfSpaces, int numberOfBathrooms, boolean hasGarden, ConstructionType constructionType) {
        super(ID, price, neighborhood, area, numberOfSpaces, numberOfBathrooms);
        this.hasGarden = hasGarden;
        this.constructionType = constructionType;
    }
}

