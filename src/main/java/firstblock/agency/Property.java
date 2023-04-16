package firstblock.agency;

import firstblock.agency.enums.Neighborhood;
import firstblock.agency.interfaces.IIdentifiable;


public abstract class Property implements IIdentifiable {
    private String id;
    private Neighborhood neighborhood;
    private int basePrice;

    public Property(String id, int basePrice, Neighborhood neighborhood) {
        this.id = id;
        setBasePrice(basePrice);
        this.neighborhood = neighborhood;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public String getId() {
        return id;
    }

    private void setBasePrice(int basePrice) {
        if (basePrice > 0)
            this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public abstract int calculateFinalPrice();


    @Override
    public String toString() {
        return "ID: " + id +
                ", neighborhood: " + neighborhood +
                ", ";
    }
}