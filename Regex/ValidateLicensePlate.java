package Regex;

import java.util.Scanner;

public class ValidateLicensePlate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plate = sc.nextLine();
        if (plate.matches("^[A-Z]{2}\\d{4}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        sc.close();
    }
}
