package JavaConstructor;

import java.util.Scanner;

class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500.0;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new registration fee: ");
        double fee = sc.nextDouble();
        sc.nextLine();
        Vehicle.updateRegistrationFee(fee);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter owner name: ");
            String owner = sc.nextLine();
            System.out.print("Enter vehicle type: ");
            String type = sc.nextLine();
            vehicles[i] = new Vehicle(owner, type);
        }

        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
        }

        sc.close();
    }
}
