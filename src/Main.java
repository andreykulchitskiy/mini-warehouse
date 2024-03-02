import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_MESSAGE = "Neplatný vstup, zadejte číslo znovu:";
    private static final String UNKNOWN_INPUT_MESSAGE = "Neznamý vstup, zkuste znovu, prosím";

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        ProductManager productManager = new ProductManager();
        Cart cart = new Cart();
        initializeProducts(productManager);
        ConsoleNavigation(1);
    }

    public static void initializeProducts(ProductManager productManager) {
        productManager.addProduct(new Product("Rajčata (kg)", "1234567890123", Category.ZELENINA, 50, 8));
        productManager.addProduct(new Product("Jabka (kg)", "1234567890124", Category.OVOCE, 20, 8));
        productManager.addProduct(new Product("Hovezí máso (500g)", "1234567890125", Category.MASO, 200, 2));
        productManager.addProduct(new Product("Okurka 1 ks", "1234567890123", Category.ZELENINA, 15, 8));
        productManager.addProduct(new Product("Pomeranč 1 ks", "1234567890124", Category.OVOCE, 10, 8));
        productManager.addProduct(new Product("Kuřecí máso (500g)", "1234567890125", Category.MASO, 120, 2));
        productManager.addProduct(new Product("Čipsy", "1234567890123", Category.TRVANLIVE, 50, 15));
        productManager.addProduct(new Product("Čokolada", "1234567890124", Category.TRVANLIVE, 25, 15));
        productManager.addProduct(new Product("Chleba", "1234567890125", Category.TRVANLIVE, 25, 15));
        productManager.initializeWarehouseProducts();
    }
    public static void ConsoleNavigation(int step) {
        switch (step) {
            case 1:
                printCommands();
                handleCommandInput(readIntInput());
                break;
            case 2:
                printCategories();
                handleCategoryInput(readIntInput());
                break;
            case 3:
                handleShoppingChoice();
                break;
            default:
                System.out.println("Neplatna volba.");
                break;
        }
    }

    public static int readIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println(INVALID_INPUT_MESSAGE);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void handleCommandInput(int commandChoice) {
        switch (commandChoice) {
            case 1:
                ConsoleNavigation(2);
                break;
            case 2:
                ConsoleNavigation(3);
                break;
            case 3: break;
            default:
                System.out.println(UNKNOWN_INPUT_MESSAGE);
                ConsoleNavigation(1);
                break;
        }
    }

    public static void handleCategoryInput(int categoryChoice) {
        switch (categoryChoice) {
            case 1:
            case 2:
            case 3:
            case 4:
                handleCategory(Category.values()[categoryChoice - 1]);
                break;
            case 0:
                ConsoleNavigation(1);
                break;
            default:
                System.out.println(UNKNOWN_INPUT_MESSAGE);
                ConsoleNavigation(2);
                break;
        }
    }

    public static void handleShoppingChoice() {
        int shoppingIndex = 1;
        Cart.printCartContents();
        for (Shoppingcommand shoppingcommand : Shoppingcommand.values()) {
            System.out.println(shoppingIndex++ + ". " + shoppingcommand.getShoppingcommandName());
        }
        System.out.println("Pro navrat zpatky zmačknete 0");
        int shoppingChoice = readIntInput();
        switch (shoppingChoice) {
            case 1:
                removeFromCart();
                break;
            case 2:
                if (!Cart.getItems().isEmpty()) {

                    Order order = new Order(new ArrayList<>(Cart.getItems()));

                    System.out.println("Váš objednávka byla úspěšně dokončena.");
                    System.out.println("Číslo vaší objednávky: " + order.getOrderNumber());
                    System.out.println("Obsah vaší objednávky:");
                    for (CartItem item : Cart.getItems()) {
                        System.out.println(item.getProduct().getName() + " - " + item.getQuantity() + " ks");
                    }


                    Cart.clearCart();
                    Warehouse.printAllOrders();

                    ConsoleNavigation(1);
                } else {
                    System.out.println("Váš košík je prázdný. Nemůžete dokončit objednávku.");
                    ConsoleNavigation(3);
                }
                break;

            case 0:
                ConsoleNavigation(1);
                break;
            default:
                System.out.println("Neplatna volba.");
                break;
        }
    }

    public static void removeFromCart() {
        System.out.println("Jaky produkt chcete odebrat?");
        Cart.printCartContents();
        int productChoice = readIntInput();
        if (productChoice > 0 && productChoice <= Cart.getItems().size()) {
            CartItem selectedCartItem = Cart.getItems().get(productChoice - 1);
            Cart.removeProduct(selectedCartItem.getProduct());
            System.out.println("Produkt " + selectedCartItem.getProduct().getName() + " byl odebran z kosiku.");
            ConsoleNavigation(3);
        } else {
            System.out.println("Neplatny vyber produktu.");
        }
    }
    public static void printCommands() {
        System.out.println("Vyberte kam chcete pokracovat:");
        int commandIndex = 1;
        for (Command command : Command.values()) {
            System.out.println(commandIndex++ + ". " + command.getCommandName());
        }
    }

    public static void printCategories() {
        System.out.println("Vyberte kategorii:");
        int categoryIndex = 1;
        for (Category category : Category.values()) {
            System.out.println(categoryIndex++ + ". " + category.getCategoryName());
        }
        System.out.println("Pro navrat zpatky zmačknete 0");
    }

    public static void handleCategory(Category category) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vyberte prosim z produktu a napiste jaky chcete pridat do kosiku, pokud zadny tak zmacknete 0 ");
        List<Product> products = ProductManager.findProductsByCategory(category);
        ProductManager.printProductsWithNumbers(products);
        int productChoice = scanner.nextInt();
        if (productChoice != 0 && productChoice > 0 && productChoice <= products.size()) {
            Product selectedProduct = products.get(productChoice - 1);
            Cart.addProduct(selectedProduct);
            System.out.println("Produkt " + selectedProduct.getName() + " byl pridan do kosiku.");
        } else {
            System.out.println("Neplatny vyber produktu.");
        }
        ConsoleNavigation(2);
    }

}



