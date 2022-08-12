package hometask.two.enums;

import hometask.two.exceptions.OptionOutOfRangeException;

public enum Neighborhood {
    SHINJUKU, ASAKUSA, GINZA, SHIBUYA;

    private static Neighborhood[] getNeighborhoodValues() {
        Neighborhood[] listOfNeighborhoods = Neighborhood.values();
        return listOfNeighborhoods;
    }

    public static void showNeighborhoodsByNumber() {
        Neighborhood[] listOfNeighborhoods = getNeighborhoodValues();
        for (Neighborhood n : listOfNeighborhoods) {
            System.out.println((n.ordinal() + 1) + ". " + n);
        }
    }

    public static Neighborhood saveChosenNeighborhood(int numOfChosenNeighborhood) {
        Neighborhood[] listOfNeighborhoods = new Neighborhood[0];
        if (numOfChosenNeighborhood > Neighborhood.getNeighborhoodValues().length) {
            throw new OptionOutOfRangeException();
        } else {
            listOfNeighborhoods = getNeighborhoodValues();
            Neighborhood chosenNeighborhood = listOfNeighborhoods[numOfChosenNeighborhood - 1];
            return chosenNeighborhood;
        }
    }
}
