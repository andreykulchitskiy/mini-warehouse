import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 public class Warehouse {

     private static List<Order> orders;

     Warehouse() {
         this.orders = new ArrayList<>();
     }

     public static void addOrder(Order order) {
         orders.add(order);
         updateSectorInventory(order);
     }

     private static Map<String, Integer> sectorInventory;

     static {
         sectorInventory = new HashMap<>();
         sectorInventory.put("3", 0);
         sectorInventory.put("6", 0);
         sectorInventory.put("7", 0);
     }

     public static void printSectorInventory() {
         System.out.println("======================================");
         System.out.println("| Sektor  | Počet objednavek |");
         System.out.println("======================================");
         for (Map.Entry<String, Integer> entry : sectorInventory.entrySet()) {
             String sector = entry.getKey();
             int count = entry.getValue();
             System.out.printf("| %-8s| %-17d|\n", sector, count);
         }
         System.out.println("======================================");
     }

     private static void updateSectorInventory(Order order) {
         for (CartItem item : order.getItems()) {
             Product product = item.getProduct();
             String productEAN = product.getEAN();
             int quantity = item.getQuantity();
             String sector = findSectorByProductEAN(productEAN);
             if (sector != null) {
                 sectorInventory.put(sector, sectorInventory.getOrDefault(sector, 0) + quantity);
             }
         }
     }
     private static String findSectorByProductEAN(String productEAN) {
         for (WarehouseProduct warehouseProduct : ProductManager.warehouseProducts) {
             if (warehouseProduct.getProduct().getEAN().equals(productEAN)) {
                 return warehouseProduct.getSector();
             }
         }
         return null;
     }

     public static void printAllOrders() {
         if (orders.isEmpty()) {
             System.out.println("Na skaldě nejsou objednavky");
         } else {
             System.out.println("Na skaldě jsou tyto objednavky:");
             for (Order order : orders) {
                 System.out.println("Objednavka čislo " + order.getOrderNumber() + ":");
                 for (CartItem item : order.getItems()) {
                     System.out.println("- " + item.getProduct().getName() + ": " + item.getQuantity() + " ks.");
                 }
             }
         }
     }

     public static void printWarehouseProducts() {
         if (ProductManager.warehouseProducts.isEmpty()) {
             System.out.println("Na skladě nejsou zboží");
         } else {
             System.out.println("Skladská zásoba:");
             for (WarehouseProduct warehouseProduct : ProductManager.warehouseProducts) {
                 System.out.println("Nazev: " + warehouseProduct.getProduct().getName());
                 System.out.println("Počet: " + warehouseProduct.getQuantity());
                 System.out.println("Sektor: " + warehouseProduct.getSector());
                 System.out.println();
             }
         }
     }
 }
