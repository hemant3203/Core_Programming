package Four_Pillars;

import java.util.Scanner;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return itemName + " - Qty: " + quantity + " - ₹" + price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    public String getDiscountDetails() {
        return "10% discount on Veg items";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 20 * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "5% discount on Non-Veg items";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FoodItem[] order = new FoodItem[2];
        order[0] = new VegItem("Paneer Roll", 100, 2);
        order[1] = new NonVegItem("Chicken Wings", 150, 3);

        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());
            double total = item.calculateTotalPrice();
            double discount = 0;
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                discount = d.applyDiscount();
                System.out.println(d.getDiscountDetails());
            }
            System.out.println("Total Price: ₹" + total);
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final Amount: ₹" + (total - discount));
            System.out.println();
        }

        sc.close();
    }
}
