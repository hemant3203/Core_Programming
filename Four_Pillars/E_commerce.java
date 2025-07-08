package Four_Pillars;

import java.util.Scanner;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "18% GST applicable on Electronics.";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "5% GST applicable on Clothing.";
    }
}

class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class E_commerce{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] cart = new Product[3];

        System.out.println("Enter details for Electronics:");
        System.out.print("ID: ");
        String id1 = sc.nextLine();
        System.out.print("Name: ");
        String name1 = sc.nextLine();
        System.out.print("Price: ");
        double price1 = sc.nextDouble();
        sc.nextLine();
        cart[0] = new Electronics(id1, name1, price1);

        System.out.println("Enter details for Clothing:");
        System.out.print("ID: ");
        String id2 = sc.nextLine();
        System.out.print("Name: ");
        String name2 = sc.nextLine();
        System.out.print("Price: ");
        double price2 = sc.nextDouble();
        sc.nextLine();
        cart[1] = new Clothing(id2, name2, price2);

        System.out.println("Enter details for Groceries:");
        System.out.print("ID: ");
        String id3 = sc.nextLine();
        System.out.print("Name: ");
        String name3 = sc.nextLine();
        System.out.print("Price: ");
        double price3 = sc.nextDouble();
        cart[2] = new Groceries(id3, name3, price3);

        System.out.println("\n--- Final Prices ---");
        for (Product p : cart) {
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0.0;
            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Product: " + p.getName());
            System.out.println("Original Price: ₹" + p.getPrice());
            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);
            if (p instanceof Taxable) {
                System.out.println(((Taxable) p).getTaxDetails());
            }
            System.out.println();
        }

        sc.close();
    }
}
