package firstblock.agency.enums;

import firstblock.agency.exceptions.OptionOutOfRangeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Neighborhood {
    SHINJUKU, ASAKUSA, GINZA, SHIBUYA;

    static final Logger LOG_NEIGHBORHOOD = LogManager.getLogger(Neighborhood.class.getName());

    private static Neighborhood[] getNeighborhoodValues() {
        Neighborhood[] listOfNeighborhoods = Neighborhood.values();
        return listOfNeighborhoods;
    }

    public static void showNeighborhoodsByNumber() {
        Neighborhood[] listOfNeighborhoods = getNeighborhoodValues();
        for (Neighborhood n : listOfNeighborhoods) {
            LOG_NEIGHBORHOOD.info((n.ordinal() + 1) + ". " + n);
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
