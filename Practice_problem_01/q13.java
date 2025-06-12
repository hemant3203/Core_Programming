package Practice_problem_01;

import java.util.Scanner;

public class q13 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        int quotient = num1 / num2; // Division
        int remainder = num1 % num2; // Modulo
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + num1 + " and " + num2);
    sc.close();
    }
}
