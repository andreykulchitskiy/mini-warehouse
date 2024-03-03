import java.util.List;

public class Order {
    private static int orderCounter = 0;
    private String orderNumber;

    private List<CartItem> items;

    public Order(List<CartItem> items) {
        this.items = items;
        this.orderNumber = generateOrderNumber();
        Warehouse.addOrder(this);
    }

    public List<CartItem> getItems() {
        return this.items;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }


    private String generateOrderNumber() {
        String baseNumber = "108779";
        String orderIndex = String.format("%04d", orderCounter++);
        return baseNumber + orderIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Objednávka číslo: ").append(orderNumber).append("\n");
        sb.append("Produkty:\n");
        for (CartItem item : items) {
            sb.append("- ").append(item.getProduct().getName()).append("\n");
        }
        return sb.toString();
    }
}

