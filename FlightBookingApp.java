import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

class Flight {
    String flightNumber;
    String origin;
    String destination;

    public Flight(String flightNumber, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public String toString() {
        return flightNumber + ": " + origin + " ➔ " + destination;
    }
}

class Booking {
    String passengerName;
    Flight flight;

    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public String toString() {
        return "Passenger: " + passengerName + " | " + flight.toString();
    }
}

public class FlightBookingApp extends Application {

    Flight[] flights = {
        new Flight("AI101", "Delhi", "Mumbai"),
        new Flight("BA202", "Mumbai", "Bangalore"),
        new Flight("AI303", "Chennai", "Delhi"),
        new Flight("QA404", "Kolkata", "Hyderabad")
    };

    List<Booking> bookings = new ArrayList<>();

    ListView<String> searchResults = new ListView<>();
    ListView<String> bookingList = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("✈️ Flight Booking System");

        // Flight Search UI
        TextField originField = new TextField();
        originField.setPromptText("Enter Origin City");

        TextField destinationField = new TextField();
        destinationField.setPromptText("Enter Destination City");

        Button searchBtn = new Button("🔍 Search Flights");
        searchBtn.setMaxWidth(Double.MAX_VALUE);

        searchBtn.setOnAction(e -> {
            searchResults.getItems().clear();
            String origin = originField.getText().trim();
            String dest = destinationField.getText().trim();
            for (Flight flight : flights) {
                if (flight.origin.equalsIgnoreCase(origin) && flight.destination.equalsIgnoreCase(dest)) {
                    searchResults.getItems().add(flight.toString());
                }
            }
            if (searchResults.getItems().isEmpty()) {
                searchResults.getItems().add("❌ No flights found.");
            }
        });

        VBox searchPane = new VBox(10, originField, destinationField, searchBtn, searchResults);
        searchPane.setPadding(new Insets(10));
        searchPane.setAlignment(Pos.CENTER);
        TitledPane searchGroup = new TitledPane("🔎 Search Flights", searchPane);
        searchGroup.setCollapsible(false);

        // Booking UI
        TextField passengerField = new TextField();
        passengerField.setPromptText("Passenger Name");

        TextField flightNumberField = new TextField();
        flightNumberField.setPromptText("Flight Number");

        Button bookBtn = new Button("✅ Book Flight");
        bookBtn.setMaxWidth(Double.MAX_VALUE);

        Button clearBookingsBtn = new Button("🗑️ Clear All Bookings");
        clearBookingsBtn.setMaxWidth(Double.MAX_VALUE);

        bookBtn.setOnAction(e -> {
            String flightNumber = flightNumberField.getText().trim();
            String name = passengerField.getText().trim();

            Flight found = null;
            for (Flight flight : flights) {
                if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                    found = flight;
                    break;
                }
            }

            if (found != null && !name.isEmpty()) {
                bookings.add(new Booking(name, found));
                bookingList.getItems().add("✔ " + name + " booked " + found.flightNumber);
            } else {
                bookingList.getItems().add("❌ Booking failed: invalid flight or name.");
            }
        });

        clearBookingsBtn.setOnAction(e -> {
            bookings.clear();
            bookingList.getItems().clear();
        });

        VBox bookingPane = new VBox(10, passengerField, flightNumberField, bookBtn, clearBookingsBtn, bookingList);
        bookingPane.setPadding(new Insets(10));
        bookingPane.setAlignment(Pos.CENTER);
        TitledPane bookingGroup = new TitledPane("📋 Book Flight & View Bookings", bookingPane);
        bookingGroup.setCollapsible(false);

        // Root Layout
        HBox root = new HBox(20, searchGroup, bookingGroup);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #f4f4f4;");

        Scene scene = new Scene(root, 700, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
