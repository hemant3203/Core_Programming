package ClassAndObject.Level_02;
import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addQuantity(int qty) {
        quantity += qty;
    }

    void removeQuantity(int qty) {
        quantity = Math.max(0, quantity - qty);
    }

    void displayTotalCost() {
        System.out.println("Item: " + itemName + ", Quantity: " + quantity + ", Total Cost: " + (price * quantity));
    }
}

public class ShoppingCartSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String itemName = sc.nextLine();
        double price = sc.nextDouble();
        int quantity = sc.nextInt();
        CartItem item = new CartItem(itemName, price, quantity);
        int choice = sc.nextInt();
        if (choice == 1) {
            int addQty = sc.nextInt();
            item.addQuantity(addQty);
        } else if (choice == 2) {
            int removeQty = sc.nextInt();
            item.removeQuantity(removeQty);
        }
        item.displayTotalCost();
        sc.close();
    }
}
