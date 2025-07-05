package LinkedList;

import java.util.Scanner;

public class OnlineTicketReservationSystem {

    class Node {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Node next;

        Node(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    Node head = null;

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Node newNode = new Node(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Node curr = head;
        Node prev = null;

        // Special case: Only one node
        if (head.next == head && head.ticketId == ticketId) {
            head = null;
            System.out.println("Ticket with ID " + ticketId + " removed.");
            return;
        }

        boolean found = false;
        Node temp = head;
        while (temp.next != head) {
            if (temp.ticketId == ticketId) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        // Check the last node
        if (temp.ticketId == ticketId) {
            found = true;
        }

        if (!found) {
            System.out.println("Ticket ID not found.");
            return;
        }

        // Deletion logic
        if (temp == head) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        } else {
            prev.next = temp.next;
        }

        System.out.println("Ticket with ID " + ticketId + " removed.");
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Node temp = head;
        boolean started = false;

        System.out.println("\n--- Booked Tickets ---");
        while (temp != head || !started) {
            started = true;
            printTicket(temp);
            temp = temp.next;
        }
    }

    void searchByCustomer(String name) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Node temp = head;
        boolean found = false, started = false;

        while (temp != head || !started) {
            started = true;
            if (temp.customerName.equalsIgnoreCase(name)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No tickets found for customer: " + name);
        }
    }

    void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Node temp = head;
        boolean found = false, started = false;

        while (temp != head || !started) {
            started = true;
            if (temp.movieName.equalsIgnoreCase(movie)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No tickets found for movie: " + movie);
        }
    }

    void countTickets() {
        if (head == null) {
            System.out.println("Total tickets booked: 0");
            return;
        }

        int count = 0;
        Node temp = head;
        boolean started = false;

        while (temp != head || !started) {
            started = true;
            count++;
            temp = temp.next;
        }

        System.out.println("Total tickets booked: " + count);
    }

    void printTicket(Node node) {
        System.out.println("Ticket ID: " + node.ticketId);
        System.out.println("Customer Name: " + node.customerName);
        System.out.println("Movie Name: " + node.movieName);
        System.out.println("Seat Number: " + node.seatNumber);
        System.out.println("Booking Time: " + node.bookingTime);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        OnlineTicketReservationSystem system = new OnlineTicketReservationSystem();
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Book New Ticket");
            System.out.println("2. Cancel Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer Name");
            System.out.println("5. Search Ticket by Movie Name");
            System.out.println("6. Count Total Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    system.removeTicket(sc.nextInt());
                    sc.nextLine();
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name: ");
                    system.searchByCustomer(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Movie Name: ");
                    system.searchByMovie(sc.nextLine());
                    break;
                case 6:
                    system.countTickets();
                    break;
                case 0:
                    System.out.println("Exiting Ticket Reservation System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
