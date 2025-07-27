
package Generics;

import java.util.*;

interface Category {}

class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    String getDetails() {
        return name + " - " + price;
    }
}

public class DynamicMarketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        double price = sc.nextDouble();
        Product<BookCategory> book = new Product<>(name, price, new BookCategory());
        applyDiscount(book, 10);
        System.out.println(book.getDetails());
        sc.close();
    }
}
