public class Product {
    private String name;
    private String EAN;
    private Category category;

    private Integer price;
    private int storageTemperature;

    public Product(String name, String EAN, Category category, int price, int storageTemperature) {
        this.name = name;
        this.EAN = EAN;
        this.category = category;
        this.price = price;
        this.storageTemperature = storageTemperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public Category getCategory() {
        return category;
    }


    public int getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature(int storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public Integer getPrice(){
        return price;
    }
    public void setPrice(){
        this.price = price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", EAN='" + EAN + '\'' +
                ", category='" + category + '\'' +
                ", storageTemperature='" + storageTemperature + '\'' +
                '}';
    }
}
