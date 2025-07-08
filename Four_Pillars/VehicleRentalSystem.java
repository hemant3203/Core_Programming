package Four_Pillars;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    public String getInsuranceDetails() {
        return "Standard Car Insurance";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    public String getInsuranceDetails() {
        return "Two-Wheeler Insurance";
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("C101", 1000);
        vehicles[1] = new Bike("B202", 300);
        vehicles[2] = new Truck("T303", 2000);

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Type: " + v.getType());
            double cost = v.calculateRentalCost(5);
            System.out.println("Rental Cost for 5 days: ₹" + cost);
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance: ₹" + ins.calculateInsurance());
                System.out.println(ins.getInsuranceDetails());
            }
            System.out.println();
        }

        sc.close();
    }
}
