package hometask.two.enums;

public enum PropertyType {
    HOUSE, APARTMENT, LAND;

    public static PropertyType[] getPropertyTypesByNumber() {
        PropertyType[] typesOfProperties = PropertyType.values();
        return typesOfProperties;
    }

    public static void showPropertyTypesByNumber() {
        PropertyType[] typesOfProperties = getPropertyTypesByNumber();
        for (PropertyType type : typesOfProperties) {
            System.out.println((type.ordinal() + 1) + ". " + type);
        }
    }

    public static PropertyType saveChosenPropertyType(int numOfTypeChosen) {
        PropertyType[] typesOfProperties = getPropertyTypesByNumber();
        PropertyType chosenPropertyType = typesOfProperties[(numOfTypeChosen - 1)];
        return chosenPropertyType;
    }
}
