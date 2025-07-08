package Four_Pillars;

import java.util.Scanner;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleDetails() {
        return vehicleId + " - " + driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

class RideCar extends Vehicle implements GPS {
    private String currentLocation;

    public RideCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class RideBike extends Vehicle implements GPS {
    private String currentLocation;

    public RideBike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class RideAuto extends Vehicle {
    public RideAuto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicle[] rides = new Vehicle[3];
        rides[0] = new RideCar("CAR001", "David", 15);
        rides[1] = new RideBike("BIKE001", "Sara", 8);
        rides[2] = new RideAuto("AUTO001", "Ravi", 10);

        double distance = 10;

        for (Vehicle v : rides) {
            System.out.println(v.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: ₹" + v.calculateFare(distance));
            if (v instanceof GPS) {
                ((GPS) v).updateLocation("Central Station");
                System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            }
            System.out.println();
        }

        sc.close();
    }
}
