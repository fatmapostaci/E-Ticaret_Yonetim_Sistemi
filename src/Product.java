public class Product {
    final int base=10000;
    static int productIdCounter;
    int productId;
    String name;
    String category;
    double price;
    int stock;


    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.productId= base + productIdCounter++;
    }

    @Override
    public String toString() {
        return  " productId= " + productId +
                " name= " + name +
                " category= " + category +
                " price= " + price +
                " stock="  + stock +"\n";
    }
}
