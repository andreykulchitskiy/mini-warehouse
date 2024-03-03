public class WarehouseProduct {
    private Product product;
    private String sector;
    private Integer quantity;


    public WarehouseProduct(Product product, String sector, Integer quantity) {
        this.product = product;
        this.sector = sector;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public  Integer getQuantity()
    {
        return this.quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }


}
