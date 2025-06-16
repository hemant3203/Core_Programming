package Arrays;

import java.util.Scanner;

public class MultiplicationTable_01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to print its multiplication table: ");
        int number = sc.nextInt();

        int[] multiplicationResult = new int[10];

        for (int i = 1; i <= 10; i++) {
            multiplicationResult[i - 1] = number * i;
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 1]);
        }

        sc.close();
    }
}
