package Built_in_Functions;

import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = getInput(sc, "Enter a non-negative integer to find its factorial: ");
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long fact = factorial(number);
            displayResult(number, fact);
        }

        sc.close();
    }

    public static int getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void displayResult(int n, long fact) {
        System.out.println("Factorial of " + n + " is: " + fact);
    }
}
