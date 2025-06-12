package Practice_problem_01;

import java.util.Scanner;

public class q9 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Get height input from user
        System.out.print("Enter your height in cm: ");
        double heightCm = sc.nextDouble();
        double totalInches = heightCm / 2.54;
        int feet = (int)(totalInches / 12);
        double inches = totalInches % 12;
        sc.close();
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f\n", heightCm, feet, inches);
    }
}
