package firstblock.agency.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum PropertyType {
    HOUSE, APARTMENT, LAND;

    static final Logger LOG_PROP_TYPE = LogManager.getLogger(PropertyType.class.getName());

    public static PropertyType[] getPropertyTypesByNumber() {
        PropertyType[] typesOfProperties = PropertyType.values();
        return typesOfProperties;
    }

    public static void showPropertyTypesByNumber() {
        PropertyType[] typesOfProperties = getPropertyTypesByNumber();
        for (PropertyType type : typesOfProperties) {
            LOG_PROP_TYPE.info((type.ordinal() + 1) + ". " + type);
        }
    }

    public static PropertyType saveChosenPropertyType(int numOfTypeChosen) {
        PropertyType[] typesOfProperties = getPropertyTypesByNumber();
        PropertyType chosenPropertyType = typesOfProperties[(numOfTypeChosen - 1)];
        return chosenPropertyType;
    }
}
