import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceApp {

    static ArrayList<Product> productList = new ArrayList<>();
    static ArrayList<Order> orderList= new ArrayList<>();
    static int totalSoldProducts;

    public static void main(String[] args) {



        Product notebook = new Product("Notebook" , "Electronics",5350.0,340);
        Product blanket = new Product("Blanket" , "HomeStuff",1530.0,90);
        Product babydoll = new Product("Babydoll" , "Toys",750.0,40);
        productList.addAll(List.of(notebook,blanket,babydoll));
        System.out.println(productList);

        Order.menu();



    }



}
