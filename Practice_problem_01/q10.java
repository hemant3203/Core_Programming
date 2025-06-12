package Practice_problem_01;

import java.util.Scanner;

public class q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // User input for fee and discount
        System.out.print("Enter the fee: ");
        double fee = sc.nextDouble();
        System.out.print("Enter the discount percent: ");
        double discountPercent = sc.nextDouble();
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f\n", discount, finalFee);
    sc.close();
    }
}
