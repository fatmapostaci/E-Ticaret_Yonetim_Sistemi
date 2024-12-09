import java.util.ArrayList;
import java.util.Scanner;

public class ECommerceApp {

    static ArrayList<Product> productList;
    static ArrayList<Order> orderList;
    static int totalSoldProducts;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {

        System.out.println("   - 1: **Ürün Ekle**: Kullanıcıdan ürün bilgilerini alıp listeye ekleyin.\n" +
                "   - 2: **Ürünleri Listele**: Mevcut ürünleri yazdırın.\n" +
                "   - 3: **Sipariş Oluştur**: Kullanıcının seçtiği bir ürün için sipariş oluşturun.\n" +
                "   - 4: **Toplam Satılan Ürünleri Görüntüle**.\n" +
                "   - 5: **Çıkış**.");
    }

    private static void addNewProduct(){
        Scanner sc = new Scanner(System.in);

    }

    private static void listProducts(){

    }

    private static void orderProduct(){

    }

    private static void listSoldProducts(){

    }


}
