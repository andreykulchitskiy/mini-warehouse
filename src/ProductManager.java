import java.util.ArrayList;
import java.util.List;

    public class ProductManager {
        public static List<Product> productList;
        static List<WarehouseProduct> warehouseProducts;

        public ProductManager() {
            this.productList = new ArrayList<>();
            warehouseProducts = new ArrayList<>();

        }

        public static void addProduct(Product product) {
            productList.add(product);
        }

        public void removeProduct(Product product) {
            productList.remove(product);
        }


        public Product findProductByEAN(String EAN) {
            for (Product product : productList) {
                if (product.getEAN().equals(EAN)) {
                    return product;
                }
            }
            return null;
        }
        public static List<Product> findProductsByCategory(Category category) {
            List<Product> productsWithCategory = new ArrayList<>();
            for (Product product : productList) {
                if (product.getCategory() == category) {
                    productsWithCategory.add(product);
                }
            }
            return productsWithCategory;
        }


        public static void printProductsWithNumbers(List<Product> products) {
            int counter = 1;
            for (Product product : products) {
                System.out.println(counter++ + ". " + product.getName());
            }
        }


        public List<Product> getAllProducts() {
            return productList;
        }


        public static void addWarehouseProduct(WarehouseProduct product) {
            warehouseProducts.add(product);
        }

        public void removeWarehouseProduct(WarehouseProduct product) {
            warehouseProducts.remove(product);
        }

        public WarehouseProduct findWarehouseProductByEAN(String EAN) {
            for (WarehouseProduct product : warehouseProducts) {
                if (product.getProduct().getEAN().equals(EAN)) {
                    return product;
                }
            }
            return null;
        }

        public static void initializeWarehouseProducts() {
            for (Product product : productList) {
                String sector = determineSector(product.getStorageTemperature());
                WarehouseProduct warehouseProduct = new WarehouseProduct(product, sector, 50);
                warehouseProducts.add(warehouseProduct);
            }
        }

        private static String determineSector(int storageTemperature) {
            // Определяем сектор на основании температуры хранения
            if (storageTemperature >= 5 && storageTemperature <= 10) {
                return "6";
            } else if (storageTemperature >= 12 && storageTemperature <= 20) {
                return "3";
            } else {
                return "7";
            }
        }



    }

