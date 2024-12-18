import java.util.List;
import java.util.Scanner;

public class Order {
    final int base = 20000;
    static int orderIdCounter;
    int orderId;
    Product product;
    int quantity;
    double totalPrice;

    static Scanner sc = new Scanner(System.in);

    public Order(int quantity, Product product) {
        this.totalPrice = product.price*quantity;
        this.quantity = quantity;
        this.product = product;
        this.orderId = base + orderIdCounter++;
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
    public static void addNewProduct() {

        System.out.print("Sisteme eklenecek ürün adı: ");
        String name = sc.next();
        System.out.print("Kategori bilgisi: ");
        String category = sc.next();
        System.out.print("Ürün fiyatı: ");
        double price = sc.nextDouble();
        System.out.print("Ürün stoğu: ");
        int stock = sc.nextInt();

        Product pen = new Product(name, category, price, stock);
        ECommerceApp.productList.add(pen);
    }

    /**
     * Mevcut ürünleri yazdırır
     *
     * @param
     */
    public static void listProducts() {
        for (Order orderedProduct : ECommerceApp.orderList)
            System.out.println(orderedProduct);
    }

    /**
     * Kullanıcının seçtiği bir ürün için sipariş oluşturur.
     */
    public static void orderProduct() {
        //the products is listed before asking for productId
        listProducts();

        int productId = 0;
        try {
            System.out.print("Sipariş edilecek ürün ID: ");
            productId = TryCatch.intGirisi();
        } catch (Exception e) {

            System.out.println("ID kabul edilmedi. " + e);
            //productId question will be asked recursively until an acceptable id is entered
            orderProduct();
        }

        for (Product p : ECommerceApp.productList) {
            if (p.productId == productId) {
                System.out.print("Sipariş adeti: ");
                int quantity = TryCatch.intGirisi();
                Order newOrder = new Order(quantity, p);
                ECommerceApp.orderList.add(newOrder);
                System.out.println(productId);
                break;
            }//productId listede yok ise else bloğu çalışır
            //     else {
            //         System.out.println("ID kabul edilmedi. ");
            //         //productId question will be asked recursively until an acceptable id is entered
            //         orderProduct();

            //     }
        }
    }//rakam girilmediğinde exception bloğu çalışır.


    public static void listSoldProducts() {
        System.out.println(ECommerceApp.orderList);

    }


}