package Practice_problem_01;

import java.util.Scanner;

public class q12 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking user input for unit price and quantity
        System.out.print("Enter the unit price: ");
        double unitPrice = sc.nextDouble();
        System.out.print("Enter the quantity: ");
        int quantity = sc.nextInt();
        double total = unitPrice * quantity;
        System.out.printf("The total purchase price is INR %.2f if the quantity %d and the unit price is INR %.2f\n", total, quantity, unitPrice);
    sc.close();
    }
}
