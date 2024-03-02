import java.util.List;
import java.util.ArrayList;
 public class Warehouse {

     private static List<Order> orders;

     Warehouse() {
         this.orders = new ArrayList<>();
     }

     public static void addOrder(Order order) {
         orders.add(order);


     }

     public static void printAllOrders() {
         if (orders.isEmpty()) {
             System.out.println("Na skladě nejsou objednavky");
         } else {
             System.out.println("Na skladě jsou tyto objednavky:");
             for (Order order : orders) {
                 System.out.println(order);
             }
         }
     }

     public static void printWarehouseProducts() {
         if (ProductManager.warehouseProducts.isEmpty()) {
             System.out.println("Na skladě nejsou zboží");
         } else {
             System.out.println("Skladská zásoba:");
             for (WarehouseProduct warehouseProduct : ProductManager.warehouseProducts) {
                 System.out.println("Nazev" + warehouseProduct.getProduct().getName());
                 System.out.println("Počet: " + warehouseProduct.getQuantity());
                 System.out.println("Sektor: " + warehouseProduct.getSector());
                 System.out.println();
             }
         }


     }
 }
