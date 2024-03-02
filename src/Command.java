public enum Command {
    KOSIK ("Košik"),
    PRIDAT_PRODUKT ("Přidat produkt"),
    ODEBRAT_PRODUKT ("Odebrat produkt"),
    OBJENDAT ("Objednat"),
    VYHLEDAVANI_ZBOZI ("Vyhledávání zboží");
    private final String operationName;

    Command(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }
}
