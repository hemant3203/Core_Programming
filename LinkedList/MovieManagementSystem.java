package LinkedList;

import java.util.Scanner;

public class MovieManagementSystem {
    static class Node {
        String title;
        String director;
        int year;
        double rating;
        Node prev, next;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null, tail = null;

    void addAtBeginning(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void addAtEnd(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Node newNode = new Node(title, director, year, rating);
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    void removeByTitle(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
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
                return;
            }
            temp = temp.next;
        }
    }

    void searchByDirector(String director) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movies found by that director");
    }

    void searchByRating(double rating) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movies found with that rating");
    }

    void updateRatingByTitle(String title, double newRating) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagementSystem movie = new MovieManagementSystem();
        while (true) {
            System.out.println("1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Title\n5. Search by Director\n6. Search by Rating\n7. Update Rating by Title\n8. Display Forward\n9. Display Backward\n10. Exit");
            int choice = sc.nextInt();
            if (choice == 10)
                break;
            switch (choice) {
                case 1:
                    System.out.println("Enter Title, Director, Year, Rating:");
                    movie.addAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter Title, Director, Year, Rating:");
                    movie.addAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Enter Position, Title, Director, Year, Rating:");
                    movie.addAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Enter Title:");
                    movie.removeByTitle(sc.next());
                    break;
                case 5:
                    System.out.println("Enter Director:");
                    movie.searchByDirector(sc.next());
                    break;
                case 6:
                    System.out.println("Enter Rating:");
                    movie.searchByRating(sc.nextDouble());
                    break;
                case 7:
                    System.out.println("Enter Title and New Rating:");
                    movie.updateRatingByTitle(sc.next(), sc.nextDouble());
                    break;
                case 8:
                    movie.displayForward();
                    break;
                case 9:
                    movie.displayBackward();
                    break;
            }
        }
        sc.close();
    }
}
