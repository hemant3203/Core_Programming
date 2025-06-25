package JavaConstructor;

import java.util.Scanner;

class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    private double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookDetails() {
        System.out.println("ISBN (public): " + ISBN);
        System.out.println("Title (protected): " + title);
        System.out.println("Author (via getter): " + getAuthor());
        System.out.println("File Size (MB): " + fileSizeMB);
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter file size in MB: ");
        double size = sc.nextDouble();

        EBook ebook = new EBook(isbn, title, author, size);
        ebook.displayEBookDetails();

        sc.close();
    }
}
