package ClassAndObject.Level_01;
import java.util.Scanner;

class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails(int quantity) {
        System.out.println("Item Code: " + itemCode + ", Item Name: " + itemName + ", Price: " + price + ", Total Cost: " + (price * quantity));
    }
}

public class ItemInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int itemCode = sc.nextInt();
        sc.nextLine();
        String itemName = sc.nextLine();
        double price = sc.nextDouble();
        int quantity = sc.nextInt();
        Item item = new Item(itemCode, itemName, price);
        item.displayDetails(quantity);
        sc.close();
    }
}
