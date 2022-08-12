package hometask.two.enums;

public enum Operation {
    RENT, BUY;

    private static Operation[] getOperationValues() {
        Operation[] listOfOperations = Operation.values();
        return listOfOperations;
    }

    public static void showOperationsByNumber() {
        Operation[] listOfOperations = getOperationValues();
        for (Operation o : listOfOperations) {
            System.out.println((o.ordinal() + 1) + ". " + o);
        }
    }
}
