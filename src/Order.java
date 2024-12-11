import java.util.List;
import java.util.Scanner;

public class Order {
    static int orderIdCounter;
    int orderId;
    Product product;
    int quantity;
    double totalPrice;

    static Scanner sc = new Scanner(System.in);

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
    public static void menu() {

        System.out.println("   - 1: **Ürün Ekle**: \n" +
                "   - 2: **Ürünleri Listele**: \n" +
                "   - 3: **Sipariş Oluştur**: \n" +
                "   - 4: **Toplam Satılan Ürünleri Görüntüle**.\n" +
                "   - 5: **Çıkış**.");
    }

    /**
     * Kullanıcıdan ürün bilgilerini alıp listeye ekler.
     */
    public static void addNewProduct(List<Product> productList ){
        System.out.print("Sisteme eklenecek ürün adı: ");
        String name = sc.next();
        System.out.print("Kategori bilgisi: ");
        String category = sc.next();
        System.out.print("Ürün fiyatı: ");
        double price = sc.nextDouble();
        System.out.print("Ürün adedi: ");
        int stock = sc.nextInt();

        Product pen = new Product( name, category, price, stock );
        productList.add(pen);
    }

    /**
     * Mevcut ürünleri yazdırır
     * @param productList
     */
    public static void listProducts(List<Product> productList){
        for (Product p : productList)
            System.out.println(p);
    }

    /**
     * Kullanıcının seçtiği bir ürün için sipariş oluşturur.
     */
    public static void orderProduct(Product p, List<Order> orderList){
        System.out.print("Sipariş edilecek ürün ID: ");
        p.productId = sc.nextInt();
        System.out.print("Sipariş adeti: ");
        int quantity = sc.nextInt();
        Order order1 = new Order(quantity, p);
        orderList.add(order1);
    }

    public static void listSoldProducts(){

    }

}