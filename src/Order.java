public class Order {
    static int orderIdCounter;
    int orderId;
    Product product;
    int quantity;
    double totalPrice;

    public Order(int quantity, Product product) {
        this.totalPrice += product.price;
        this.quantity = quantity;
        this.product = product;
        this.orderId= orderIdCounter++;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}