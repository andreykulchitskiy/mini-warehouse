public enum Shoppingcommand {
    ODEBRAT_PRODUKT ("Odebrat produkt"),
    OBJENDAT ("Objednat");
    private final String operationName;

    Shoppingcommand(String operationName) {
        this.operationName = operationName;
    }

    public String getShoppingcommandName() {
        return operationName;
    }

}
