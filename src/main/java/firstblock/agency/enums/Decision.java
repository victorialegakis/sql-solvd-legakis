package firstblock.agency.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Decision {
    YES, NO;

    static final Logger LOG_DECISION = LogManager.getLogger(Decision.class.getName());

    public static Decision[] getOptionsByNumber() {
        Decision[] options = Decision.values();
        return options;
    }


    public static void showOptionsByNumber() {
        Decision[] options = getOptionsByNumber();
        for (Decision logical : options) {
            LOG_DECISION.info((logical.ordinal() + 1) + ". " + logical);
        }
    }
}
