import java.util.List;
import java.util.Scanner;

/**
 * This class represents an Order in the e-commerce application.
 * It includes details about the product, quantity, and total price of the order.
 * It also provides utility methods for managing orders and interacting with the user.
 */
public class Order {
    //Base value for generating unique order IDs.
    final int base = 20000;

    //base coloured syntax value
    public static final String G = "\u001B[33m";
    public static final String B = "\u001B[34m";

    // Counter for generating unique order IDs.
    static int orderIdCounter;

    // Unique ID of the order.
    int orderId;

    // The product associated with the order.
    Product product;

    // The quantity of the product ordered.
    int quantity;

    // The total price of the order (product price * quantity).
    double totalPrice;

    // Scanner instance for reading user input.
    static Scanner sc = new Scanner(System.in);

    /**
     * Constructs a new Order with the specified quantity and product.
     *
     * @param quantity the quantity of the product being ordered
     * @param product  the product being ordered
     */
    public Order(int quantity, Product product) {
        this.totalPrice = product.price * quantity;
        this.quantity = quantity;
        this.product = product;
        this.orderId = base + orderIdCounter++;
    }

    /**
     * Returns a string representation of the order.
     *
     * @return a string containing the order details
     */
    @Override
    public String toString() {
        return
                "    orderId: " + orderId +
                "    product: "+ product +
                "    quantity: "+ quantity +
                "    totalPrice: " + totalPrice ;
    }

    /**
     * Displays the menu options for the e-commerce application and processes user selections.
     *
     * The menu includes the following options:
     *
     *     Add a new product
     *     List all products
     *     Create a new order
     *     View all sold products
     *     Exit the application
     *
     * Based on the user's input, the corresponding method is executed.
     * The menu runs in an infinite loop until the user selects the exit option.
     */
    public static void menu() {
        while (true){
            System.out.println(G +"--------------------MENU--------------------- \n" +
                    "   - 1: **Ürün Ekle**: \n" +
                    "   - 2: **Ürünleri Listele**: \n" +
                    "   - 3: **Sipariş Oluştur**: \n" +
                    "   - 4: **Toplam Satılan Ürünleri Görüntüle**.\n" +
                    "   - 5: **Çıkış**\n"+
                    "--------------------MENU--------------------- \n" +G);
            System.out.printf( "Seçiminizi yapın: ");
            int secim = TryCatch.intInput();

            switch (secim){
                case 1: addNewProduct(); break;
                case 2: listProducts(); break;
                case 3: orderProduct(); break;
                case 4: listSoldProducts(); break;
                case 5: System.exit(0); break;
                default: break;
            }
        }

    }

    /**
     * Prompts the user to add a new product and adds it to the product list.
     * Collects product name, category, price, and stock from the user.
     */
    public static void addNewProduct() {
        System.out.println(B+"---------Sisteme Yeni Ürün Ekleme------- ");
        System.out.print("Ürün adı: ");
        String name = TryCatch.stringInput();
        System.out.print("Kategori bilgisi: ");
        String category = TryCatch.stringInput();
        System.out.print("Ürün fiyatı: ");
        double price = TryCatch.doubleInput();
        System.out.print("Ürün stoğu: ");
        int stock = TryCatch.intInput();

        Product pen = new Product(name, category, price, stock);
        try {
            ECommerceApp.productList.add(pen);
            System.out.println("Ürün başarıyla eklendi.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Creates an order for a selected product.
     * <p>
     * Lists all available products, prompts the user for a product ID and quantity,
     * and adds a new order to the order list if the input is valid.
     * <p>
     * If the product ID is invalid, the user is notified and prompted again recursively.
     */
    public static void orderProduct() {

        System.out.println(B+"---------Listedeki Ürünlerden Sipariş Oluşturun------- ");

        int productId = 0;

        System.out.print("Ürün ID: ");
        //
        productId = TryCatch.intInput();

        boolean flag = false;
        Product selectedProduct = null;
        for (Product p : ECommerceApp.productList) {
            if (p.productId == productId) {
                selectedProduct=p;
                flag = true;
            }}
        if (flag==true){
                System.out.print("Sipariş adeti: ");
                int quantity = TryCatch.intInput();
                Order newOrder = new Order(quantity, selectedProduct);
                ECommerceApp.orderList.add(newOrder);
                System.out.println(productId);
                
            } else {
                //If the product ID is invalid, the user is notified and prompted again recursively.
                // The products are listed before asking for productId
                System.out.println("GEÇERSİZ ID!");
                listProducts();
                orderProduct();
            }
        
    }

    /**
     * Lists all products in the product list.
     */
    public static void listProducts() {

        System.out.println(B+"---------------------------------Sisteme Yüklenen Ürün Listesi------------------------- ");

        for (Product products : ECommerceApp.productList)
            System.out.println(B+products);
        System.out.println(B+"--------------------------------------------------------------------------------------- ");
    }

    /**
     * Lists all sold products by displaying the orders in the order list.
     */
    public static void listSoldProducts() {

        System.out.println(B+"--------------------------------Sipariş Edilen Ürün Listesi---------------------------- ");
        for (Order orders : ECommerceApp.orderList)
            System.out.println(B+orders);
        System.out.println(B+"--------------------------------------------------------------------------------------- ");
    }
}