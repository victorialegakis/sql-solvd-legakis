package hometask.two.enums;

public enum Decision {
    YES, NO;

    public static Decision[] getOptionsByNumber() {
        Decision[] options = Decision.values();
        return options;
    }


    public static void showOptionsByNumber() {
        Decision[] options = getOptionsByNumber();
        for (Decision logical : options) {
            System.out.println((logical.ordinal() + 1) + ". " + logical);
        }
    }
}
