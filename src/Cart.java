import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public static void addProduct(Product product) {

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.incrementQuantity();
                return;
            }
        }

        items.add(new CartItem(product, 1));
    }

    public static void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public static void clearCart() {
        items.clear();
    }

    public static List<CartItem> getItems() {
        return items;
    }

    public static double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public static void printCartContents() {
        if (items.isEmpty()) {
            System.out.println("Košik je prazdny.");
            Main.ConsoleNavigation(1);
        } else {
            System.out.println("Obsah košiku:");
            for (int i = 0; i < items.size(); i++) {
                CartItem item = items.get(i);
                System.out.println((i + 1) + ". " + item.getProduct().getName() + " x" + item.getQuantity() + " - " + item.getProduct().getPrice() * item.getQuantity()); // Печатаем название продукта, количество и общую стоимость за этот продукт
            }
            System.out.println("Celkova cena: " + getTotalPrice());
        }
    }
}
