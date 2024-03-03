public enum CommandsForWarehouse {
    Kompletace ("Prehled objednavek"),
    Balanc ("Balanc"),
    Zasoby("Skladská zásoba"),
    DalsiObhednavka("Udelat objednavku"),
    Exit("Exit");
    private final String operationName;

    CommandsForWarehouse(String operationName) {
        this.operationName = operationName;
    }
    public String getCommandName() {
        return operationName;
    }
}
