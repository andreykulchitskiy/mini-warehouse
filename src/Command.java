public enum Command {
    VYHLEDAVANI_ZBOZI ("Vyhledávání zboží"),
    KOSIK ("Košik"),
    EXIT ("Exit");
    private final String operationName;

    Command(String operationName) {
        this.operationName = operationName;
    }
    public String getCommandName() {
        return operationName;
    }
}
