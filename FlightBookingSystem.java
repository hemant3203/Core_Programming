import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    String flightNumber;
    String origin;
    String destination;

    // used Constructor
    public Flight(String flightNumber, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    // Display only flight details
    public void displayFlight() {
        System.out.println("Flight Number: " + flightNumber + ", From: " + origin + ", To: " + destination);
    }
}

class Booking {
    String passengerName;
    Flight flight;

    // used a Constructor
    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    // Display booking detail
    public void displayBooking() {
        System.out.println("Passenger: " + passengerName);
        flight.displayFlight();
    }
}

public class FlightBookingSystem {

    // Flight array 
    static Flight[] flights = {
        new Flight("AI101", "Delhi", "Mumbai"),
        new Flight("BA202", "Mumbai", "Bangalore"),
        new Flight("AI303", "Chennai", "Delhi"),
        new Flight("QA404", "Kolkata", "Hyderabad")
    };

    // Bookings list
    static List<Booking> bookings = new ArrayList<>();

    // Search flights 
    public static void searchFlights(String origin, String destination) {
        boolean found = false;
        System.out.println("Searching for flights from " + origin + " to " + destination);
        for (Flight flight : flights) {
            if (flight.origin.equalsIgnoreCase(origin) && flight.destination.equalsIgnoreCase(destination)) {
                flight.displayFlight();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }

    //function to Book a flight
    public static void bookFlight(String flightNumber, String passengerName) {
        for (Flight flight : flights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                bookings.add(new Booking(passengerName, flight));
                System.out.println("Booking successful for " + passengerName);
                return;
            }
        }
        System.out.println("Flight number not found.");
    }

    // Display all Booking Information
    public static void displayAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings made yet.");
        } else {
            System.out.println("All Bookings:");
            for (Booking booking : bookings) {
                booking.displayBooking();
                System.out.println("---------------");
            }
        }
    }

    // Main method to start the code 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nFlight Booking System Menu:");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // for newline

            switch (choice) {
                case 1:
                    System.out.print("Enter origin: ");
                    String origin = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine();
                    searchFlights(origin, destination);
                    break;

                case 2:
                    System.out.print("Enter flight number to book: ");
                    String flightNumber = sc.nextLine();
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    bookFlight(flightNumber, name);
                    break;

                case 3:
                    displayAllBookings();
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
