package Four_Pillars;

import java.util.Scanner;

interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemDetails() {
        return itemId + " - " + title + " by " + author;
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 21;
    }

    public boolean reserveItem() {
        return true;
    }

    public boolean checkAvailability() {
        return true;
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public boolean reserveItem() {
        return false;
    }

    public boolean checkAvailability() {
        return true;
    }
}

class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LibraryItem[] items = new LibraryItem[3];
        items[0] = new Book("B001", "The Java Guide", "John Doe");
        items[1] = new Magazine("M010", "Tech Monthly", "EditorX");
        items[2] = new DVD("D100", "Inception", "Christopher Nolan");

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                System.out.println("Reservable: " + res.reserveItem());
                System.out.println("Available: " + res.checkAvailability());
            }
            System.out.println();
        }

        sc.close();
    }
}
