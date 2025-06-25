// package Final_Static;
// import java.util.Scanner;

// class Product {
//     static double discount;
//     private final int productID;
//     private String productName;
//     private double price;
//     private int quantity;

//     Product(String productName, double price, int quantity, int productID) {
//         this.productName = productName;
//         this.price = price;
//         this.quantity = quantity;
//         this.productID = productID;
//     }

//     static void updateDiscount(double newDiscount) {
//         discount = newDiscount;
//     }

//     void displayDetails() {
//         System.out.println("Product ID: " + productID);
//         System.out.println("Product Name: " + productName);
//         System.out.println("Price per unit: " + price);
//         System.out.println("Quantity: " + quantity);
//         System.out.println("Discount: " + discount + "%");
//         double discountedPrice = price - (price * discount / 100);
//         System.out.println("Price after discount per unit: " + discountedPrice);
//         System.out.println("Total Price after discount: " + (discountedPrice * quantity));
//     }
// }

// public class ShoppingCartSystem {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter initial discount percentage: ");
//         double initialDiscount = sc.nextDouble();
//         sc.nextLine();
//         Product.updateDiscount(initialDiscount);

//         System.out.print("Enter number of products: ");
//         int n = sc.nextInt();
//         sc.nextLine();

//         Product[] products = new Product[n];

//         for (int i = 0; i < n; i++) {
//             System.out.print("Enter Product Name: ");
//             String name = sc.nextLine();
//             System.out.print("Enter Price: ");
//             double price = sc.nextDouble();
//             System.out.print("Enter Quantity: ");
//             int quantity = sc.nextInt();
//             System.out.print("Enter Product ID: ");
//             int productID = sc.nextInt();
//             sc.nextLine();

//             products[i] = new Product(name, price, quantity, productID);
//         }

//         System.out.print("Enter new discount percentage to update (or enter same value to keep): ");
//         double newDiscount = sc.nextDouble();
//         sc.nextLine();
//         Product.updateDiscount(newDiscount);

//         System.out.println("Products after applying discount:");

//         for (Product product : products) {
//             if (product instanceof Product) {
//                 product.displayDetails();
//                 System.out.println();
//             }
//         }

//         sc.close();
//     }
// }

package Final_Static;
import java.util.*;

class Product{
    static double discount;
    private String productname;
    private double price;
    private int quantity;
    private final int productID;

    Product(String productname,double price, int quantity,int productID){
      this.productname=productname;
      this.price=price;
      this.quantity=quantity;
      this.productID=productID;
    }

    static void updateDiscount(double newDiscount){
        discount=newDiscount;
    }

    void displayDetails(){
         System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productname);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        double discountedPrice = price - (price * discount / 100);
        System.out.println("Price after discount per unit: " + discountedPrice);
        System.out.println("Total Price after discount: " + (discountedPrice * quantity));
    }

}
public class ShoppingCartSystem{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the initial discount Percantage");
        double initailDiscount=sc.nextDouble();
           sc.nextLine();
           Product.updateDiscount(initailDiscount);

           System.out.println("Enter the number of products: ");
           int n=sc.nextInt();
           sc.nextLine();

           Product[] products=new Product[n];

           for(int i=0;i<n;i++){
            System.out.println("Enter Product Name: ");
            String name=sc.nextLine();
             System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            System.out.print("Enter Product ID: ");
            int productID = sc.nextInt();
            sc.nextLine();

            products[i]=new Product(name,price,quantity,productID);
           }

           System.out.println("Enter new Discount percentage or keep it dame");
           double newDiscount=sc.nextDouble();
           sc.nextLine();
           Product.updateDiscount(newDiscount);

           System.out.println("Product after applying discount");

           for(Product p:products){
            if(p instanceof Product){
                p.displayDetails();
                System.out.println();
            }
           }
           sc.close();
        }
    }
