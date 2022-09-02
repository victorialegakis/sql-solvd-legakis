package hometask.agency.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Operation {
    RENT, BUY;

    static final Logger LOG_OP = LogManager.getLogger(Operation.class.getName());

    private static Operation[] getOperationValues() {
        Operation[] listOfOperations = Operation.values();
        return listOfOperations;
    }

    public static void showOperationsByNumber() {
        Operation[] listOfOperations = getOperationValues();
        for (Operation o : listOfOperations) {
            LOG_OP.info((o.ordinal() + 1) + ". " + o);
        }
    }
}
