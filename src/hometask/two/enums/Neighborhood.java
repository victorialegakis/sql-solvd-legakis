package hometask.two.enums;

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
        Neighborhood[] listOfNeighborhoods = getNeighborhoodValues();
        Neighborhood chosenNeighborhood = listOfNeighborhoods[numOfChosenNeighborhood - 1];

        return chosenNeighborhood;
    }
}
