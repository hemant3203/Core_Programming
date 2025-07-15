import java.util.*;
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book b = (Book) obj;
            return title.equals(b.title) && author.equals(b.author);
        }
        return false;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

class BookNode {
    Book book;
    BookNode next;

    BookNode(Book book) {
        this.book = book;
        this.next = null;
    }
}

class BookLinkedList {
    private BookNode head;

    public void add(Book book) {
        if (contains(book)) {
            System.out.println("Duplicate not added: " + book);
            return;
        }

        BookNode newNode = new BookNode(book);
        if (head == null) {
            head = newNode;
        } else {
            BookNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + book);
    }

    public boolean remove(Book book) {
        if (head == null) return false;

        if (head.book.equals(book)) {
            head = head.next;
            return true;
        }

        BookNode current = head;
        while (current.next != null) {
            if (current.next.book.equals(book)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean contains(Book book) {
        BookNode current = head;
        while (current != null) {
            if (current.book.equals(book)) return true;
            current = current.next;
        }
        return false;
    }

    public void display() {
        BookNode current = head;
        while (current != null) {
            System.out.println("- " + current.book);
            current = current.next;
        }
    }
}

public class MyLibrary {

    static Map<String, BookLinkedList> catalog = new HashMap<>();

    static void addBook(String genre, Book book) {
        catalog.putIfAbsent(genre, new BookLinkedList());
        catalog.get(genre).add(book);
    }

    static void borrowBook(String genre, Book book) {
        BookLinkedList list = catalog.get(genre);
        if (list != null && list.remove(book)) {
            System.out.println("Borrowed: " + book);
        } else {
            System.out.println("Book not found in " + genre);
        }
    }

    static void returnBook(String genre, Book book) {
        addBook(genre, book);
    }

    static void displayCatalog() {
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            catalog.get(genre).display();
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Harry Potter", "J.K. Rowling");
        Book b2 = new Book("The Hobbit", "Tolkien");
        Book b3 = new Book("1984", "George Orwell");

        addBook("Fantasy", b1);
        addBook("Fantasy", b2);
        addBook("Dystopian", b3);
        addBook("Fantasy", b1);

        System.out.println("\n--- Catalog ---");
        displayCatalog();

        borrowBook("Fantasy", b1);
        System.out.println("\n--- After Borrowing ---");
        displayCatalog();

        returnBook("Fantasy", b1);
        System.out.println("\n--- After Returning ---");
        displayCatalog();
    }
}
