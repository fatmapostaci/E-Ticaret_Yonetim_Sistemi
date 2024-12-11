import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceApp {

    static ArrayList<Product> productList;
    static ArrayList<Order> orderList;
    static int totalSoldProducts;

    public static void main(String[] args) {

        Order.menu();
        Order.addNewProduct(productList);

//        Product notebook = new Product("Notebook" , "Electronics",5350.0,340);
//        Product blanket = new Product("Blanket" , "HomeStuff",1530.0,90);
        //Order school = new Order(3,productList.get(0));

    }



}
