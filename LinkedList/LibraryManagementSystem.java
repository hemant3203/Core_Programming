package LinkedList;

import java.util.Scanner;

public class LibraryManagementSystem {

    class Node {
        String title;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        Node next;
        Node prev;

        Node(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;

    void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (pos <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        Node temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    void removeByBookId(int bookId) {
        if (head == null) return;

        Node temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head && temp == tail) {
            head = tail = null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book with ID " + bookId + " removed.");
    }

    void searchByTitle(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }

    void searchByAuthor(String author) {
        Node temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book by author \"" + author + "\" not found.");
    }

    void updateAvailability(int bookId, boolean isAvailable) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    void displayForward() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No books in the library.");
            return;
        }
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Node temp = tail;
        if (temp == null) {
            System.out.println("No books in the library.");
            return;
        }
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    void displayBook(Node node) {
        System.out.println("Title: " + node.title);
        System.out.println("Author: " + node.author);
        System.out.println("Genre: " + node.genre);
        System.out.println("Book ID: " + node.bookId);
        System.out.println("Available: " + (node.isAvailable ? "Yes" : "No"));
        System.out.println("-----------------------");
    }

    void countBooks() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear bad input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    lib.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    lib.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    lib.addAtPosition(pos, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    lib.removeByBookId(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.print("Enter Book Title to search: ");
                    lib.searchByTitle(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Author Name to search: ");
                    lib.searchByAuthor(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Enter Book ID and new Availability (true/false): ");
                    lib.updateAvailability(sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                    break;
                case 8:
                    lib.displayForward();
                    break;
                case 9:
                    lib.displayReverse();
                    break;
                case 10:
                    lib.countBooks();
                    break;
                case 0:
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
