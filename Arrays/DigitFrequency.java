package Arrays;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digitArray = new int[10];
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            digitArray[digit]++;
            temp /= 10;
        }

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (digitArray[i] > 0) {
                System.out.println("Digit " + i + " occurs " + digitArray[i] + " time(s)");
            }
        }

        sc.close();
    }
}
